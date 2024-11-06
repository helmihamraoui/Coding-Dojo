from flask_app import app
from flask import render_template,redirect,request,session,flash
from flask_app.models.user_model import User
from flask_app.models.friend_model import Friend
from flask_bcrypt import Bcrypt # type: ignore

bcrypt=Bcrypt(app)
@app.route('/')
def registration():
    return render_template('index.html')
@app.route('/register/create',methods=['post'])
def create_new():
    if User.validate(request.form):
        pw=bcrypt.generate_password_hash(request.form['password'])
        data={
            **request.form,
            "password":pw
        }
        user_id=User.register(data)
        session["user_id"]=user_id
        return redirect('/dashboard')
    else:
        return redirect('/')
@app.route('/login',methods=['POST'])
def login():
    user=User.get_one({'email':request.form['email']})
    if not user :
        flash("Invalide Email/password",'login')
        return redirect('/')
    if not bcrypt.check_password_hash(user.password,request.form['password']):
        flash("Invalide Email/password",'login')
        return redirect('/')
    session['user_id']=user.id
    return redirect('/dashboard')
@app.route('/dashboard')
def home():
    if  'user_id' in session:
        messages=Friend.my_messages({'id':session["user_id"]})
        return render_template('home.html',messages=messages,liste=User.get_all({'id':session["user_id"]}),login_user=User.get_one_by_id({'id':session["user_id"]}),)
    else:
        return redirect('/')
@app.route("/logout",methods=['POST'])
def logout():
    session.clear()
    return redirect('/')
@app.route('/send/<int:id>',methods=["post"])
def send_message(id):
    data={
        "user_id":session['user_id'],
        "friend_id":id,
        'message':request.form['message']
        }
    Friend.new_friend(data)
    return redirect('/dashboard')
@app.route("/remove/message/<int:friend_id>/<int:user_id>",methods=["post"])
def remove(friend_id,user_id):
    Friend.remove({"friend_id":friend_id,"user_id":user_id})
    return redirect('/dashboard')
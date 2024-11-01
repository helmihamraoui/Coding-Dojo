from flask import request,render_template,redirect # type: ignore
from app_flask.models.users_model import User # type: ignore
from app_flask import app # type: ignore
@app.route('/')
def index():
    return render_template("display_users.html",users=User.get_all())
@app.route('/user/new')
def new_user():
    return render_template("index.html")
@app.route('/user/form',methods=["POST"])
def create_new():
    new_user={
        "first_name":request.form["first_name"],
        "last_name":request.form["last_name"],
        "email":request.form["email"]
    }
    user=User.save(new_user)
    return redirect("/show/"+str(user))
@app.route('/show/<int:id>')
def show_one(id):
    user=User.get_one({'id':id})
    return render_template("display_card.html",user=user)
@app.route('/delet/<int:id>')
def delet(id):
    User.delet_one({'id':id})
    return redirect("/")
@app.route('/update/<int:id>')
def update_one(id):
    user=User.get_one({'id':id})
    return render_template("update.html",user=user)
@app.route('/user/update/<int:id>',methods=["POST"])
def update(id):
    new_user={
        "first_name":request.form["first_name"],
        "last_name":request.form["last_name"],
        "email":request.form["email"]
    }
    User.update_one(id,new_user)
    return redirect('/show/'+str(id))
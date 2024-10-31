from flask import Flask, render_template,redirect,request,session # type: ignore
from users_model import User
app=Flask(__name__)
app.secret_key='password12'
@app.route('/user')
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
    User.save(new_user)
    return redirect("/user")
if __name__=="__main__":
    app.run(debug=True)
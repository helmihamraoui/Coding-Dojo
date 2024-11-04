from flask import render_template,redirect,request
from flask_app import app
from flask_app.models.ninjas_model import Ninja
from flask_app.models.dojos_model import Dojo
@app.route('/')
def page_home():
    return redirect('/dojos')
@app.route('/ninjas')
def ninja_form():
    return render_template('form_ninja.html',liste=Dojo.get_dojos())
@app.route('/new/ninjas',methods=["POST"])
def create_ninja():
    new_ninja={
        "dojo_id":int(request.form["dojo_id"]),
        "first_name":request.form["first_name"],
        "last_name":request.form["last_name"],
        "age":int(request.form["age"])
    }
    print("/"*90)
    print(new_ninja)
    Ninja.creat_new(new_ninja)
    return redirect('/dojo/'+str(new_ninja["dojo_id"]))
    

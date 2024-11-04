from flask import render_template,request,redirect # type: ignore
from flask_app.models.dojo_model import Dojo
from flask_app import app
@app.route("/")
def form():
    return render_template("index.html")
@app.route("/create/new",methods=["POST"])
def create_new():
    if Dojo.validation(request.form):
        id=Dojo.creat_new(request.form)
        return redirect("/result/"+str(id))
    else :
        return redirect("/")
@app.route("/result/<int:id>")
def result(id):
    return render_template("resulta.html",liste=Dojo.get_by_id({"id":id}))
from flask import render_template,request,redirect,session # type: ignore
from flask_app.models.email_model import Email
from flask_app import app


@app.route('/')
def home():
    return render_template("index.html")
@app.route('/new',methods=["POST"])
def create_new():
    if Email.valide(request.form):
        session['id']=Email.creat_new(request.form)
        return redirect('/succes')
    else:
        return redirect('/')
@app.route('/succes')
def get_all():
    emails=Email.get_all_email()
    id=session['id']
    print(Email.get_one_by_id({'id':id}))
    return render_template("res.html",emails=emails,last=Email.get_one_by_id({'id':id}))
@app.route('/remove/<int:id>')
def remove_email(id):
    Email.remove({'id':id})
    return redirect('/')
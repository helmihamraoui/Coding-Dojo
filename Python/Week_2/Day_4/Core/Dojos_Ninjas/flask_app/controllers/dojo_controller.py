from flask_app import app
from flask import request,render_template,redirect
from flask_app.models.dojos_model import Dojo
@app.route('/dojos')
def dojo():
    return render_template('form_dojo.html',liste=Dojo.get_dojos())
@app.route('/dojos/new',methods=['POST'])
def new_dojo():
    Dojo.create_new_dojo(request.form)
    return redirect('/dojos')
@app.route('/dojo/<int:id>')
def show(id):
    return render_template('home.html',liste=Dojo.show_ninjas_dojo({"id":id}))
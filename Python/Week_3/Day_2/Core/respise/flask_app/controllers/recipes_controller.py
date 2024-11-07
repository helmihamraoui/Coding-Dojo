from flask_app import app
from flask import render_template,redirect,request,session,flash
from flask_app.models.recipes_model import Recipe
from flask_app.models.user_model import User
@app.route('/home')
def home():
    if  'user_id' in session:
        user=User.get_one_by_id({'id':session["user_id"]})
        posts=Recipe.get_all_post()
        return render_template('home.html',user=user,posts=posts)
    else:
        return redirect('/')
@app.route('/recipes/new')
def new_post():
    if  'user_id' in session:
        return render_template('post.html')
    return redirect('/')
@app.route('/add/new',methods=["post"])
def add_new_post():
    if  Recipe.valide(request.form):
        data={
            **request.form,
            'user_id':session['user_id']
        }
        new=Recipe.add_new(data)
        print(new)
        return redirect('/home')
    return redirect('/recipes/new')
@app.route("/recipes/edit/<int:id>")
def edit(id):
    if  'user_id' in session:
        post=Recipe.get_by_id({'id':id})
        return render_template('edit.html',post=post)
    return redirect ('/')
@app.route('/update/<int:id>',methods=['post'])
def update(id):
    if  Recipe.valide(request.form):
        Recipe.update({'id':id,**request.form})
        return redirect("/home")
    return redirect("/recipes/edit/"+str(id))
@app.route('/recipes/<int:id>')
def show(id):
    if  'user_id' in session:
        user=User.get_one_by_id({'id':session["user_id"]})
        post=Recipe.show_one({'id':id})
        return render_template("show.html",post=post,user=user)
    return redirect('/')
@app.route('/delete/<int:id>',methods=["post"])
def delete(id):
    Recipe.delete_one({'id':id})
    return redirect('/home')
from flask_app import app
from flask_app.models.authors_model import Author
from flask_app.models.books_model import Book
from flask import redirect,render_template,request
@app.route('/authors')
def home():
    return render_template("home.html",liste=Author.new())
@app.route('/author/new',methods=["post"]) 
def new_author():
    Author.create_new(request.form)
    return redirect('/authors')
@app.route('/authors/<int:id>')
def all_books(id):
    author=Author.get_one_by_id({'id':id})
    books=Book.get_all_books()
    fav=Author.all_fav({'id':id})
    return render_template("favorates_form.html",books=books,author=author,fav=fav)
@app.route("/add/<int:author_id>",methods=['post'])
def fav_by(author_id):
    new=Author.add_fav({'book_id':int(request.form['book_id']),'author_id':author_id })
    return redirect('/authors/'+str(author_id))

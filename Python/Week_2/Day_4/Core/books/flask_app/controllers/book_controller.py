from flask_app.models.books_model import Book
from flask_app.models.authors_model import Author
from flask_app import app
from flask import redirect,render_template,request
@app.route('/books')
def home_books():
    return render_template("books_form.html",liste=Book.get_all_books())
@app.route('/book/new',methods=["post"]) 
def new_book():
    Book.create_new_book(request.form)
    return redirect('/books')
@app.route("/show/books/<int:id>")
def form_book(id):
    new=Book.get_one({'id':id})
    liste=Author.new()
    book_id=id
    books=Book.all_fav_athors({"book_id":book_id})
    return render_template("books_fav.html",liste=liste,id=id,books=books,new=new)
@app.route("/add/fav/<int:id>",methods=['post'])
def add_new(id):
    print(request.form['author_id'])
    Book.add_new_fav({'book_id':id,'author_id':int(request.form['author_id'])})
    return redirect("/show/books/"+str(id))

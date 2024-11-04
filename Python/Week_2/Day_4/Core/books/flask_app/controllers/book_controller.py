from flask_app.models.books_model import Book
from flask_app import app
from flask import redirect,render_template,request
@app.route('/books')
def home_books():
    return render_template("books_form.html",liste=Book.get_all_books())
@app.route('/book/new',methods=["post"]) 
def new_book():
    Book.create_new_book(request.form)
    return redirect('/books')

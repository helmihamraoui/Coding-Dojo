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
@app.route('/authors/<int:author_id>')
def author_show(author_id):
    data = {'id': author_id}
    show_books = Book.get_by_id(data)
    books = Book.get_all_books()  
    print("/"*200)
    print(books)
    
    return render_template('favorates_form.html', show_books=show_books, books=books)
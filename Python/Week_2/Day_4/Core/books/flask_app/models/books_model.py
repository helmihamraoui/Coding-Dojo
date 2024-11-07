from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import bd
class Book:
    def __init__(self,data):
        self.id=data['id']
        self.title=data["title"]
        self.num_of_pages=data["num_of_pages"]
        self.created_at=data["created_at"]
        self.update_at=data["update_at"]
    @classmethod
    def create_new_book(cls,data):
        query="insert into books (title,num_of_pages) values (%(title)s,%(num_of_pages)s);"
        return  connectToMySQL(bd).query_db(query,data)
    @classmethod
    def get_all_books(cls):
        query="SELECT * FROM books;"
        res=connectToMySQL(bd).query_db(query)
        liste=[]
        for key in res:
            liste.append(key)
        return liste
    @classmethod
    def get_by_id(cls, id):
        query = """
        SELECT * FROM books_schema.books join books_schema.favorites on books_schema.books.id= books_schema.favorites.book_id where book_id=%(id)s
        """
        res=connectToMySQL(bd).query_db(query, id)
        return res
    @classmethod
    def get_one(cls,data):
        query="""select * from books where id =%(id)s""" 
        res=connectToMySQL(bd).query_db(query,data)   
        return res[0]
    @classmethod
    def add_new_fav(cls,data):
        query="insert into favorites (book_id,author_id) values (%(book_id)s,%(author_id)s);"
        return  connectToMySQL(bd).query_db(query,data)
    @classmethod
    def all_fav_athors(cls,data):
        query="""SELECT * 
FROM books_schema.favorites 
JOIN books_schema.books ON books_schema.books.id = books_schema.favorites.book_id 
JOIN books_schema.authors ON books_schema.authors.id = books_schema.favorites.author_id 
WHERE books_schema.favorites.book_id = %(book_id)s;"""
        res=connectToMySQL(bd).query_db(query,data)
        list_of_fav_athors=[]
        for fav in res:
            list_of_fav_athors.append(fav)
        return list_of_fav_athors
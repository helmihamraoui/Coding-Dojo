from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import bd
class Author:
    def __init__(self,data):
        self.id=data["id"]
        self.full_name=data["full_name"]
        self.created_at=data["created_at"]
        self.updated_at=data["updated_at"]
    @classmethod
    def create_new(cls,data):
        query="insert into authors (full_name) values (%(full_name)s);"
        return  connectToMySQL(bd).query_db(query,data)
    @classmethod
    def new(cls):
        query="SELECT * FROM authors;"
        res=connectToMySQL(bd).query_db(query)
        liste=[]
        for key in res:
            liste.append(key)
        return liste
    @classmethod
    def get_one_by_id(cls,data):
        query="""select * from authors where id =%(id)s""" 
        res=connectToMySQL(bd).query_db(query,data)   
        return cls(res[0])
    @classmethod
    def add_fav(cls,data):
        query="insert into favorites (book_id,author_id) values (%(book_id)s,%(author_id)s);"
        return  connectToMySQL(bd).query_db(query,data)
    @classmethod
    def all_fav(cls,data):
        query="""SELECT * 
FROM books_schema.favorites 
JOIN books_schema.books ON books_schema.books.id = books_schema.favorites.book_id 
JOIN books_schema.authors ON books_schema.authors.id = books_schema.favorites.author_id 
WHERE books_schema.favorites.author_id = %(id)s;"""
        res=connectToMySQL(bd).query_db(query,data)
        list_of_fav=[]
        for fav in res:
            list_of_fav.append(fav)
        return list_of_fav

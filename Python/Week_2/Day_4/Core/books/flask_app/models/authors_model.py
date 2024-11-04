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
    
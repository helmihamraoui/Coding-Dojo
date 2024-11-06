from flask_app import DATABASE
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash # type: ignore
import re 
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 
class Email :
    def __init__(self,data):
        self.id=data["id"]
        self.email=data["email"]
        self.created_at=data["created_at"]
        self.updated_at=data["updated_at"]
    @classmethod
    def creat_new(cls,data):
        query="""insert into email (email) values (%(email)s);"""                                                                              
        return connectToMySQL(DATABASE).query_db(query,data)
    @classmethod
    def get_one(cls,data):
        query="select * from email where email=%(email)s;"
        res=connectToMySQL(DATABASE).query_db(query,data)
        if res :
            return cls(res[0])
        else:
            return False
    @classmethod
    def get_all_email(cls):
        query="select * from email;"
        res=connectToMySQL(DATABASE).query_db(query)
        return res
    @classmethod
    def get_one_by_id(cls,data):
        query="select * from email where id=%(id)s;"
        res=connectToMySQL(DATABASE).query_db(query,data)
        return cls(res[0])
    @classmethod
    def remove(cls,data):
        query="delete from email where id=%(id)s;"
        return connectToMySQL(DATABASE).query_db(query,data)
    @staticmethod
    def valide(data):
        email=data["email"]
        is_valid=True
        if not EMAIL_REGEX.match(email): 
            flash("Invalid email address!","email_validation")
            is_valid = False
        if Email.get_one({'email':email}):
            flash(" email address exicte!","email_validation")
            is_valid = False
        return is_valid
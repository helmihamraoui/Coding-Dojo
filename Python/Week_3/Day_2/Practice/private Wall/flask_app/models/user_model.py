from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app import DB
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 


class User:
    def __init__(self,data):
        self.id=data["id"]
        self.first_name=data["first_name"]
        self.last_name=data["last_name"]
        self.email=data["email"]
        self.password=data["password"]
        self.created_at=data["created_at"]
        self.updated_at=data["updated_at"]
    @classmethod
    def register(cls,data):
        query="""insert into users (first_name,last_name,email,password) values (%(first_name)s,%(last_name)s,%(email)s,%(password)s);"""
        return connectToMySQL(DB).query_db(query,data)
    @classmethod
    def get_one(cls,data):
        query="""
                select * from users
                where email=%(email)s"""
        result=connectToMySQL(DB).query_db(query,data)
        if result:
            return cls(result[0])
        return False
    @classmethod
    def get_one_by_id(cls,data):
        query="""
                select * from users
                where id=%(id)s"""
        result=connectToMySQL(DB).query_db(query,data)
        if result:
            return cls(result[0])
        return False
    @classmethod
    def get_all(cls,data):
        query="""select * from users where id <> %(id)s;"""
        result=connectToMySQL(DB).query_db(query,data)
        user_liste=[]
        for row in result :
            user_liste.append(cls(row))
        return user_liste
    @staticmethod
    def validate(data):
        is_valid=True
        if len(data["first_name"])<2:
            flash("first name must be at least 2 characteres","first_name")
            is_valid=False
        if len(data["last_name"])<2:
            flash("first name must be at least 2 characteres","last_name")
            is_valid=False
        if not EMAIL_REGEX.match(data['email']):
            flash("email not valid","email")
            is_valid=False
        elif  User.get_one({"email":data['email']}):
            flash("email already taken","email")
            is_valid=False
        if len(data['password'])<7:
            flash("Password must contain at least 7 characters","password")
            is_valid=False
        elif data["password"] != data["confirm_password"]:
            flash("Password don't match","confirm password")
            is_valid=False
        return is_valid
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash
class Recipe:
    def __init__(self,data):
        self.id=data['id']
        self.name=data['name']
        self.description=data['description']
        self.instructions=data['instructions']
        self.data=data['data']
        self.time=data['time']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
        self.user_id=data['user_id']
    @classmethod
    def add_new(cls,data):
        query="""insert into recipe (name,description,instructions,data,time,user_id) values (%(name)s,%(description)s,%(instructions)s,%(data)s,%(time)s,%(user_id)s)"""
        resulat=connectToMySQL(DATABASE).query_db(query,data)
        return resulat
    @classmethod
    def get_all_post(cls):
        query='select* from recipe join users on recipe.user_id = users.id ;'
        resulat=connectToMySQL(DATABASE).query_db(query)
        liste_posts=[]
        for post in resulat:
            liste_posts.append(post)
        return liste_posts
    @classmethod
    def get_by_id(cls,data):
        query='select* from recipe where id=%(id)s ;'
        res=connectToMySQL(DATABASE).query_db(query,data)
        return res[0]
    @classmethod
    def update(cls,data):
        query="""UPDATE recipe SET name = %(name)s, description = %(description)s,instructions = %(instructions)s, data = %(data)s,time=%(time)s WHERE id=%(id)s;""" 
        res=connectToMySQL(DATABASE).query_db(query,data)
        return res
    @classmethod
    def show_one(cls,data):
        query='select* from recipe join users on recipe.user_id = users.id where recipe.id=%(id)s ;'
        resulat=connectToMySQL(DATABASE).query_db(query,data)
        return resulat[0]
    @classmethod
    def delete_one(cls,data):
        query="""delete from recipe where id=%(id)s;"""
        return connectToMySQL(DATABASE).query_db(query,data)
    @staticmethod
    def valide(data):
        is_valid=True
        if len(data["name"])<2:
            flash("name must be at least 2 characteres","name")
            is_valid=False
        if len(data["description"])<2:
            flash("description  must be at least 2 characteres","description")
            is_valid=False
        if len(data["instructions"])<2:
            flash(" instructions must be at least 2 characteres","instructions")
            is_valid=False
        if data["data"]=="":
            flash("data  empty !","data")
            is_valid=False
        return is_valid
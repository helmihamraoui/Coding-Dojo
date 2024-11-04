from flask_app import DATABASE
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
class Dojo:
    def __init__(self,data):
        self.id=data["id"]
        self.name=data["name"]        
        self.location=data["location"]   
        self.language=data["language"]   
        self.comment=data["comment"] 
        self.created_at=data["created_at"] 
        self.updated_at=data["updated_at"] 
    @classmethod
    def creat_new(cls,data):
        query="""insert into dojo_survey_shema.dojo_survey (name,location,language,comment) values (%(name)s,%(location)s,%(language)s,%(comment)s);"""                                                                              
        return connectToMySQL(DATABASE).query_db(query,data)
    @classmethod
    def get_by_id(cls,data):
        query="SELECT * FROM dojo_survey_shema.dojo_survey  where id= %(id)s ;"
        res=connectToMySQL(DATABASE).query_db(query,data)
        
        return cls(res[0])
    @staticmethod
    def validation(data ):
        print('-'*200)
        print(data['location'])
        is_valid = True 
        if len(data['name']) < 3:
            flash("Name must be at least 3 characters.","first_name")
            is_valid = False
        if data["location"] == "0" :
            flash("selection location .","location")
            is_valid = False
        if data["language"] == "0" :
            flash("selection language .","language")
            is_valid = False
        if len(data['comment']) < 3:
            flash("creat comment.","message")
            is_valid = False
        return is_valid
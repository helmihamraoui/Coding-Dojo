from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DB
class Dojo:
    def __init__(self,data):
        self.id=data["id"]
        self.name=data["name"]
        self.created_at=data["created_at"]
        self.update_at=data["update_at"] 
    @classmethod
    def create_new_dojo(cls,data):
        query="insert into dojos (name) values (%(name)s);"
        res=connectToMySQL(DB).query_db(query,data)
        return res
    @classmethod
    def get_dojos(cls):
        query="SELECT * FROM dojos;"
        res=connectToMySQL(DB).query_db(query)
        list_dojos=[]
        for key in res:
            list_dojos.append(key)
        return list_dojos
    @classmethod
    def show_ninjas_dojo(cls,data):
        query="SELECT * FROM ninjas join dojos on ninjas.dojo_id = dojos.id where dojos.id= %(id)s ;"
        res=connectToMySQL(DB).query_db(query,data)
        liste_ninjas_dojo=[]
        for ninja in res :
            liste_ninjas_dojo.append(ninja)
        return liste_ninjas_dojo
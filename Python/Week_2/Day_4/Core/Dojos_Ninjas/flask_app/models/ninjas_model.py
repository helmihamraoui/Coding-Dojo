from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DB # type: ignore
class Ninja:
    def __init__(self,data):
        self.id=data["id"]
        self.first_name=data["first_name"]
        self.last_name=data["last_name"]
        self.age=data["age"]
        self.created_at=data["created_at"]
        self.update_at=data["update_at"]
        self.dojo_id=data["dojo_id"]
    @classmethod
    def creat_new(cls,data):
        query="insert into ninjas (dojo_id,first_name,last_name,age) values (%(dojo_id)s,%(first_name)s,%(last_name)s,%(age)s);"
        res=connectToMySQL(DB).query_db(query,data)
        print("/"*90)
        print(res)
        return res
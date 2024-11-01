from app_flask.config.mysqlconnection import connectToMySQL
from app_flask import DATABASE # type: ignore
class User:
    def __init__(self,data):
        self.id=data['id']
        self.first_name=data['first_name']
        self.last_name=data['last_name']
        self.email=data['email']
        self.created_at=data['created_at']
        self.updated_ad=data['updated_at']
    @classmethod
    def get_all(cls):
        query="select*from DATABASE.users;"
        result=connectToMySQL(DATABASE).query_db(query)
        list_users=[]
        for user in result:
            list_users.append(cls(user))
        return  list_users
    @classmethod
    def save(cls,data):
        query="insert into users (first_name,last_name,email) values (%(first_name)s,%(last_name)s,%(email)s)"
        result=connectToMySQL(DATABASE).query_db(query,data)
        return result
    @classmethod
    def get_one(cls,id):
        query="select * from DATABASE.users where id=%(id)s ;"
        result=connectToMySQL(DATABASE).query_db(query,id)
        if result:
            return result[0]  # Return the first result if it exists
        return None
    @classmethod
    def delet_one(cls,id):
        query="DELETE FROM. WHERE id=%(id)s ;"
        result=connectToMySQL(DATABASE).query_db(query,id)
        return result
    @classmethod
    def update_one(cls,id,new_user):
        query="update. set first_name=%(first_name)s, last_name=%(last_name)s, email=%(email)s where id=%(id)s;"
        new_user['id']=id
        result=connectToMySQL(DATABASE).query_db(query,new_user)
        return result
from flask_app import DB
from flask_app.config.mysqlconnection import connectToMySQL
import datetime
class Friend:
    def __init__(self,data):
        self.user_id=data['user_id']
        self.friend_id=data['friend_id']
        self.message=data['message']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
        
    @classmethod
    def new_friend(cls,data):
        query="""insert into friend (user_id,friend_id,message) values (%(user_id)s,%(friend_id)s,%(message)s);"""
        return connectToMySQL(DB).query_db(query,data)
    @classmethod
    def my_messages(cls,data):
        query="""select * from friend join users on users.id= friend.user_id where friend_id=%(id)s ;"""
        result=connectToMySQL(DB).query_db(query,data)
        liste_message=[]
        x = datetime.datetime.now()
        for friend in result:
            friend["created_at"]=x-friend["created_at"]
            liste_message.append(friend)
        return liste_message
    @classmethod
    def remove(cls,data):
        query="""delete from friend where  user_id=%(user_id)s and friend_id=%(friend_id)s ;"""
        return connectToMySQL(DB).query_db(query,data)

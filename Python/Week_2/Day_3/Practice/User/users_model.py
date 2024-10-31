from mysqlconnection import connectToMySQL
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
        query="select*from users_schema.users;"
        result=connectToMySQL("users_schema").query_db(query)
        list_users=[]
        for user in result:
            list_users.append(cls(user))
        return  list_users
    @classmethod
    def save(cls,data):
        query="insert into users (first_name,last_name,email) values (%(first_name)s,%(last_name)s,%(email)s)"
        result=connectToMySQL("users_schema").query_db(query,data)
        return result
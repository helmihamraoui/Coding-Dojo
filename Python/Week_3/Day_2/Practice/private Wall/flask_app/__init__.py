from flask import Flask   # type: ignore
app=Flask(__name__)
app.secret_key="659851"
DB = "users_bd"
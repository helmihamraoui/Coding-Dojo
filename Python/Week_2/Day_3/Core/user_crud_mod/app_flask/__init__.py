
from flask import Flask  # type: ignore

app = Flask(__name__)
app.secret_key = "password15"

DATABASE = 'users_schema'  



from flask import Flask # type: ignore
from flask_app.config.mysqlconnection import MySQLConnection
app= Flask(__name__)
DATABASE="dojo_survey_shema"
from flask_app import app 
from flask_app.controllers.authors_controller import*
from flask_app.controllers.book_controller import*

if __name__=="__main__":
    app.run(debug=True)
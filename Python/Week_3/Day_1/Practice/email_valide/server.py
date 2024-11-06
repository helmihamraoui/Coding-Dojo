from flask_app.controllers import email_controller
from flask_app import app
app.secret_key="456987542"









if __name__ == '__main__':
    app.run(debug=True)
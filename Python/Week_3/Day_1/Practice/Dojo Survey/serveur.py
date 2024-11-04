from flask_app.controllers import dojo_controller
from flask_app import app
app.secret_key="azertyu"


if __name__ == '__main__':
    app.run(debug=True)
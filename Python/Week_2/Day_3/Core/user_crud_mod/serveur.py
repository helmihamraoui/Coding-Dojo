from app_flask import app # type: ignore
from app_flask.controllers import users_controllers # type: ignore

if __name__=="__main__":
    app.run(debug=True)
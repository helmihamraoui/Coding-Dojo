from flask import Flask   # type: ignore
app=Flask(__name__)
@app.route('/')        
def hello_world():
    return 'Hello World!' 
@app.route('/dojo')
def dojo():
    return 'Dojo!'
@app.route('/say/<name>')
def say(name):
    return f'hi {name}!'
@app.route('/repeat/<int:nb>/<name>')
def repeat(nb,name):
    return name*nb 

if __name__=="__main__":   
    app.run(debug=True) 
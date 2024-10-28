from flask import Flask, render_template, session, request  # type: ignore
app=Flask(__name__)
app.secret_key='dojoseveur'
@app.route('/')
def index():
    return render_template("index.html")
@app.route('/submit',methods=['POST'])
def submit2():
    session['name']=request.form['name']
    session['optionlocation']=request.form['optionlocation']
    session['optionlanguage']=request.form['optionlanguage']
    session['message']=request.form['message']
    return render_template("resulta.html")
@app.route('/resultat')
def resultat():
    return render_template("resulta.html")




if __name__=="__main__":
    app.run(debug=True)
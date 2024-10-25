from flask import Flask, render_template,session,redirect # type: ignore
app=Flask(__name__)
app.secret_key='azertyu'
@app.route('/')
def index():
    if 'count' in session:
        session['count']+=1
    else:
        session['count'] = 1
    return render_template("index.html",count=session['count'])
@app.route('/clear')
def clear():
    session['count']=0
    return redirect('/')







if __name__=="__main__":
    app.run(debug=True)
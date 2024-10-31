from flask import Flask, render_template, request, session, redirect # type: ignore 
import random
app = Flask(__name__)
app.secret_key = 'gess_number' 
@app.route('/')
def index():
    session['number'] = random.randint(1, 100)
    session['attempts'] = 0  
    session['max_attempts']=5
    return render_template('index.html')
@app.route('/guess', methods=['POST'])
def guess():
    print(session['number'])
    guess = int(request.form['guess'])
    session['attempts'] += 1 
    if(session['attempts']!=5):
        if guess< session['number']:
            feedback = "Too low!"
            color="red"
        elif guess > session['number']:
            feedback = "Too high!"
            color="red"
        else:
            feedback = f"Correct! It took you {session['attempts']} attempts."
            color= "green"
    elif session['attempts']==5:
        feedback = "you loser."
        color="black"
    return render_template('index.html',feedback=feedback,color=color)
if __name__ == '__main__':
    app.run(debug=True)

import React,{useState} from "react";

function PersonCard(props) {
    const [Birthday,setBirthday]=useState(props.age)
    const { index,firstname , lastname,age,color}=props
    const increase= ()=>{
        setBirthday(Birthday+1)
    }
    return (
        
            <div key={index}>
                <h1>{firstname}, {lastname}</h1>
                <p>age : {Birthday}</p>
                <p>hairColor : {color}</p>
                <button onClick={increase}>Birthday Button for {firstname} {lastname} </button>
            </div>
        
    );
    }

export default PersonCard;

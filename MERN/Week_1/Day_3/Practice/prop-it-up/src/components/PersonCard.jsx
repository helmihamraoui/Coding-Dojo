import React from "react";

function PersonCard( props ) {
    console.log(props)
    return (
        <ul>
        {props.map((person, index) => (
            <div style={{ margin:"100px" }} key={index}>
            <h1> {person.firstname}, {person.lastname}</h1>
            <p>Age: {person.age}</p>
            <p>Hair Color: {person.hairColor}</p>
            </div>
        ))}
        </ul>
    );
    }

export default PersonCard;

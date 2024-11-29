import React from "react";

function PersonCard( props ) {
    const { index,firstname , lastname,age,color}=props
    return (
        <ul>
            <div style={{ margin:"100px" }} key={index}>
            <h1> {firstname}, {lastname}</h1>
            <p>Age: {age}</p>
            <p>Hair Color: {color}</p>
            </div>
        </ul>
    );
    }

export default PersonCard;

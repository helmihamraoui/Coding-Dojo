import React from 'react'

const Show = ({boxes,deleteBox}) => {
    
    return (<div style={{ display: "flex", gap: "10px", flexWrap: "wrap" }}>
        {boxes.map((box) => (
            <div key={box.id} style={{ position: "relative" }}>
            <div
                style={{
                backgroundColor: box.color,
                width: `${box.size}px`,
                height: `${box.size}px`,
                border: "1px solid black",
            }}
            >{box.index}</div>
            <button onClick={()=>deleteBox(box.index)}>X</button>
            </div>
        ))}
        </div>
    );
    };

export default Show
import React, { useState } from 'react'

const Form = ({addBox}) => {
    const [color,setColor]=useState('')
    const [size,setSize]=useState(100)
    const [index,setindex]=useState(0)
    const HandleSubmit =(e)=>{
        e.preventDefault()
        const newBox={
            color,
            size,
            index
        }
        setindex(index+1)
        addBox(newBox)
        
    }
    return (
    <fieldset>
        <form onSubmit={HandleSubmit}>
        <label>Color :</label>
        <input name='color' value={color} onChange={ (e) => setColor(e.target.value)}/>
        <label>Size(pixels) :</label>
        <input type='number' name='size' value={size} onChange={ (e) => setSize(e.target.value)}/>
        <button>Add</button>
        </form>
    </fieldset>
    )
}

export default Form
import { useState } from 'react'
import React from 'react'
import Form from './components/Form'
import Show from './components/show';
const App = () => {
  const [boxes, setBoxes] = useState([]);
  const addBox = (newBox)=>{
    setBoxes([...boxes,newBox])
    console.log(boxes)
  }
  
  const deleteBox = (id) => {
    setBoxes(boxes.filter((box) => box.index !== id));
  };
  return (
    <div className='container mt-5'>
      <h1>Box Generator</h1>
      <Form addBox={addBox}/>
      <Show boxes={boxes} deleteBox={deleteBox}/>
    </div>
  )
}


export default App
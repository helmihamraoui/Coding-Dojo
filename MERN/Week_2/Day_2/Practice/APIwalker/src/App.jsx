import React from 'react'
import { useState } from 'react'
import {Route, Routes, useNavigate} from 'react-router-dom'
import Showone from './components/showone'
function App() {
  const nav=useNavigate()
  const [catogry,setcatogry]=useState("people")
  const[id,setId]=useState(1)
  const search=(e)=>{
      e.preventDefault()
      nav(`/${catogry}/${id}`)
      setId(1)
      setcatogry("people")

  }
  return (
    <div className="container mt-5">
        <form onSubmit={search} >
                <label>Search For :</label>
                <select value={catogry} className='form-select' name="category" id="list" onChange={(e)=>{setcatogry(e.target.value)}}>
                    <option value="people">people</option>
                    <option value="planets">planets</option>
                    <option value="starships">starships</option>
                </select>
                <label className='form-label'>ID :</label>
                <input className='form-control' type='number' value={id} onChange={(e)=>{setId(e.target.value)}}></input>
                <button className='btn btn-primary mt-2' >Search</button>
            </form>
            <Routes>
            <Route path='/:category/:id'element={< Showone />} />
            </Routes>
    </div>
  );
}

export default App;

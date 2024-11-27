import { useState } from 'react'

import './App.css'
import PersonCard from './components/PersonCard'
const person =[{
  firstname:'helmi',
  lastname:"hamraoui",
  age:"20",
  hairColor:"orange"
},{
  firstname:'aziz',
  lastname:"tounsi",
  age:"19",
  hairColor:"red"
},{
  firstname:'yassine',
  lastname:"ben abdallh",
  age:"22",
  hairColor:"blue"
}]
function App() {

  return (
    <>
      <PersonCard
      
        MyData={person}
      
      />
    </>
  )
}

export default App

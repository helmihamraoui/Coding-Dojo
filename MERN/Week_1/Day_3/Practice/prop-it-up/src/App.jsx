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
      {person.map((person, index) => {
              return <PersonCard
            key={index}
            firstname= {person.firstname}
            lastname={person.lastname}
            age={person.age}
            color={person.hairColor}
            
            />
        })}
    </>
  )
}

export default App

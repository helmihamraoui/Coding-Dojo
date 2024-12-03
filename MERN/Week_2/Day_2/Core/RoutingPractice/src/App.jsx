import { useState } from 'react'
import Home from './components/home'
import Number from './components/number'
import './App.css'
import { Route, Routes, Link } from "react-router-dom"
function App() {

  return (
    <>
    <fieldset>
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/:id" element={<Number />} />
        <Route path="/:id/:color/:bg" element={<Number />} />
      </Routes>
      </fieldset>
    </>
  )
}

export default App

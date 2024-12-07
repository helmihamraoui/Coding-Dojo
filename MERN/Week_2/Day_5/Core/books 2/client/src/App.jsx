import { Route, Routes } from "react-router-dom"
import Home from './Views/home.jsx'
import '../src/App.css'
import ShowOne from './Views/ShowOne.jsx'
import AddBook from './Views/AddBook.jsx'
function App() {
  return (
    <>
    <div>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/books/:id/details" element={<ShowOne/>}/>
        <Route path="/create" element={<AddBook/>}/>
      </Routes>
    </div>
    </>
  )
}

export default App

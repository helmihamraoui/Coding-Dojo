import React,{useState,useEffect} from 'react'
import Navbar from '../components/navbar.jsx'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios'

const ShowOne = () => {
    const nav=useNavigate()
    const [book,setBook]=useState({})
    const {id}=useParams({})
    useEffect(()=>{
        axios.get("http://localhost:5000/api/books/"+id)
        .then((res)=>{
            console.log(res.data)
            setBook(res.data)
        })
        .catch((err)=>console.error(err))
    },[])
    const remove =()=>{
        axios.delete("http://localhost:5000/api/books/"+id)
        .then((res)=>{
            nav("/")
        }).catch(err => console.log(err))
    }
    return (
    <div>
        <Navbar title={book.title}/>
        <div className='card'>
            <h4>{book.title}</h4>
            <h5>By {book.author}</h5>
            <h6>Page count : {book.pages}</h6>
            {
                book.isAvailable ? <h6>Available for borrowing</h6>: <h6>Is Not  Available </h6>
            }
            <button className='btn btn-danger' onClick={remove}> Remove </button>
        </div>
    </div>
    )
}

export default ShowOne
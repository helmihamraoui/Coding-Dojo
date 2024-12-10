import React, { useEffect, useState } from 'react'
import axios from "axios" 
import {Link } from "react-router-dom"
import Navbar from '../components/navbar'
const home = () => {
    const [books,setBooks]=useState([])
    useEffect(()=>{
        axios.get("http://localhost:5000/api/books/")
        .then((res)=>{
            console.log(res.data)
            setBooks(res.data)
        })
        .catch((err)=>console.error(err))
    },[])
    return (
    <div>
    <Navbar title="Book Catalog"/>
    <div className='container mt-4'>

    <table className="table table-striped">
    <thead>
        <tr>
        <th scope="col">Title</th>
        <th scope="col">Author</th>
        <th scope="col">Page count</th>
        <th scope="col">Availble</th>
        <th scope="col">Book Pages</th>
        </tr>
    </thead>
    <tbody>
        {
            books.map((book)=>{
                
                return<tr key={book._id}>
        <th scope="row">{book.title}</th>
        <td>{book.author}</td>
        <td>{book.pages}</td>
        <td>{book.isAvailable ? <>Yes</> : <>No</>} | <Link to={"/update/"+book._id}>edit</Link></td>
        <td> <Link to={"/books/"+ book._id +"/details"} className='btn btn-success'>Book Details</Link> </td>
        </tr>
        })
    }
    </tbody>
    </table>
    </div>
    </div>
    )
}

export default home
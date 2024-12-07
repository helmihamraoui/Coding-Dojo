import React from 'react'
import {Link } from "react-router-dom"
const navbar = (props) => {
    const {title} = props;
    
    return (
    <div className='navbar'>
        <div className='buttons'>
        <Link to='/'  className='btn btn-primary button'> Catalog </Link>
        <Link to='/create' className='btn btn-primary button'> Add Book </Link></div>
        <h1 className='title'>{title}</h1>
    </div>
    )
}

export default navbar
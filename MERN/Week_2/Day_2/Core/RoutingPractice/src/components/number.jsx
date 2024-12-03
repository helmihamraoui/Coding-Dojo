import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
const number = () => {
    const {id,color,bg}=useParams()
    console.log(isNaN(id));
    

  return (
    isNaN(id)? 
    <div className='number' style={{color: color ,backgroundColor: bg}} > The Word is : {id}</div>:
    <div className='number' >The number is : {id}</div>
  )
}

export default number
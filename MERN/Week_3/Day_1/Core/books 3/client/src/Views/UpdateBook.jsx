import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
import Navbar from '../components/navbar';

const UpdateBook = () => {
    const nav = useNavigate();
    const { id } = useParams();
    const [title,setTitle]=useState("")
    const [book, setBook] = useState({
        title: '',
        author: '',
        pages: 0,
        isAvailable: false,
    });
    const [error,setError]=useState({})
    useEffect(() => {
        axios.get(`http://localhost:5000/api/books/${id}`)
            .then((res) => {
                setBook(res.data);
                setTitle(res.data.title)
            })
            .catch((err) => console.error(err));
    }, [id]);
    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setBook((prevBook) => ({
            ...prevBook,
            [name]: type === 'checkbox' ? checked : value,
        }))
    };
    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:5000/api/books/${id}`, book)
            .then(() => {
                nav('/');
            })
            .catch((err) => {
            console.error(err)
            setError(err.response.data.errors)
        }
    );
    };
    return (
        <>
        <Navbar title={"Update "+ title}/>
        <form onSubmit={handleSubmit}>
            <div>
                <label>Title:</label>
                <input
                    type="text"
                    name="title"
                    value={book.title}
                    onChange={handleChange}
                    />
                    {error.title && <div className='alert alert-warning'>{error.title.message}</div>}
            </div>
            <div>
                <label>Author:</label>
                <input
                    type="text"
                    name="author"
                    value={book.author}
                    onChange={handleChange}
                />
                {error.author && <div className='alert alert-warning'>{error.author.message}</div>}

            </div>
            <div>
                <label>Pages:</label>
                <input
                    type="number"
                    name="pages"
                    value={book.pages}
                    onChange={handleChange}
                />
                {error.pages && <div className='alert alert-warning'>{error.pages.message}</div>}
            </div>
            <div>
                <label>Available:</label>
                <input
                    type="checkbox"
                    name="isAvailable"
                    checked={book.isAvailable}
                    onChange={handleChange}
                />
            </div>
            <button type="submit" className='btn btn-primary'>Update Book</button>
        </form>
</>
    );
};
export default UpdateBook;

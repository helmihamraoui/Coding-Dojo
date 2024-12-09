import React, { useState } from 'react';
import Navbar from '../components/navbar';
import axios from  'axios'
import { useNavigate } from 'react-router-dom';
const AddBook = () => {
    const nav = useNavigate();
    const [book, setBook] = useState({
        title: '',
        author: '',
        pages: 0,
        isAvailable: false,
    });
    const [error,setError]=useState({})
    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setBook((prevBook) => ({
            ...prevBook,
            [name]: type === 'checkbox' ? checked : value,
        }));
    };

    const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("http://localhost:5000/api/books/", book)
        .then((res) => {
            console.log("Book added successfully:", res.data);
            setBook({title: '',
                author: '',
                pages: 0,
                isAvailable: false,})
                nav('/')
        })
        .catch((err) => {
            console.log("Error adding book:", err.response.data.errors)
            setError(err.response.data.errors)

        });
};

    return (
        <div>
            <Navbar title="Add Book" />
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Title:</label>
                    <input
                        name="title"
                        type="text"
                        value={book.title}
                        onChange={handleChange}
                    />
                    {error.title && <div className='alert alert-warning'>{error.title.message}</div>}
                </div>
                <div>
                    <label>Author Name:</label>
                    <input
                        name="author"
                        type="text"
                        value={book.author}
                        onChange={handleChange}
                    />
                    {error.title && <div className='alert alert-warning'>{error.author.message}</div>}
                    
                </div>
                <div>
                    <label>Pages Count:</label>
                    <input
                        name="pages"
                        type="number"
                        value={book.pages}
                        onChange={handleChange}
                    />
                    {error.pages && <div className='alert alert-warning'>{error.pages.message}</div>}
                </div>
                <div className="checkbox">
                    <label>
                        Is it available?
                        <input
                            name="isAvailable"
                            type="checkbox"
                            checked={book.isAvailable}
                            onChange={handleChange}
                        />
                    </label>
                </div>
                <button className="btn btn-primary button" type="submit">
                    Add Book!
                </button>
            </form>
        </div>
    );
};

export default AddBook;

import React, { useState } from 'react';
import Navbar from '../components/navbar';
import axios from  'axios'
import { useNavigate } from 'react-router-dom';
const AddBook = () => {
    const nav = useNavigate();
    const [errors, setErrors] = useState({});
    const [valid,setvalid]=useState(true)
    const [typeError,setType]=useState({})
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
        }))
        validateForm();
    };
    const validateForm = () => {
        
        let formErrors = {};
        let isValid = true;
        if (book.title.length < 2) {
            formErrors.title = 'Title needs to be more than 2 characters';
            isValid = false;
        }
        if(book.author.length < 5){
            formErrors.authors = 'Author name needs to be more than 5 characters';
            isValid = false;
        }
        if(book.pages<1){
            formErrors.pages = 'pages must be at least 1 page !';
            isValid = false;
        }
        setErrors(formErrors);
        setvalid(!isValid)
        return isValid;
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
            console.log("Error adding book:", err.response)
            setError(err.response.data.errors)
            setType({
                name:err.response.data.name,
                type:err.response.status
            })
            validateForm()
        });
};
    
    return (
        <div>
            <Navbar title="Add Book" />
            <h1 className='name-erro'>{typeError && <div>{typeError.name} {typeError.type}</div>}</h1>
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
                    {errors.title && <div  className='alert alert-warning' >{errors.title }</div>}
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
                    {errors.authors && <div  className='alert alert-warning' >{errors.authors }</div>}
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
                    {errors.pages && <div  className='alert alert-warning' >{errors.pages }</div>}
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
                <button  disabled = {false}  className="btn btn-primary button" type="submit">
                    Add Book!
                </button>
            </form>
        </div>
    );
};

export default AddBook;

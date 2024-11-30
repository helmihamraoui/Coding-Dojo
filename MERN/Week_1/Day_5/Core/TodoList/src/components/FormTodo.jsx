import { useState } from 'react';

const FormTodo = ({ addTodos }) => {
    const [todo, setTodo] = useState('');

    const handleData = (e) => {
    e.preventDefault();
    addTodos(todo); 
    setTodo('');
    };

    return (
    <form onSubmit={handleData} className="p-4 border rounded bg-light">
        <div className="mb-3">
        <label htmlFor="todoInput" className="form-label">
            Todo:
        </label>
        <input
            id="todoInput"
            type="text"
            className="form-control"
            value={todo}
            onChange={(e) => setTodo(e.target.value)}
        />
        </div>
        <button type="submit" className="btn btn-primary">
        Add
        </button>
        </form>
    );
};

export default FormTodo;

import { useState } from 'react';
import FormTodo from './components/FormTodo';

function App() {
  const [todos, setTodos] = useState([]);
  const addTodos = (todo) => {
    if (todo.trim()) {
      setTodos([...todos, { text: todo, completed: false }]);
    }
  };
  const toggleTodo = (index) => {
    setTodos(
      todos.map((todo, i) =>
        
        i === index ? { ...todo, completed: !todo.completed } : todo
      )
    );
  };

  const deleteTodo = (index) => {
    setTodos(todos.filter((todo, i) => i !== index));
  };

  const show = (liste) =>
    liste.map((todo, i) => (
      <li
        className={`list-group-item d-flex gap-5 ${
          todo.completed ? 'text-danger' : ''
        }`}
        key={i}
      >
        <span style={{ textDecoration: todo.completed ? 'line-through' : 'none' }}>
          {todo.text}
        </span>
        <input
          type="checkbox"
          checked={todo.completed}
          onChange={() => toggleTodo(i)}
        />
        <button className="btn btn-danger" onClick={() => deleteTodo(i)}>
          Delete
        </button>
      </li>
    ));

  return (
    <div className="container mt-5">
      <FormTodo addTodos={addTodos} />
      <ul className="list-group list-group-numbered mt-5">{show(todos)}</ul>
    </div>
  );
}

export default App;

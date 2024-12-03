import React, { useState } from 'react';
import Form from './components/Form.jsx';
import './App.css';

function App() {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    confirmPassword: '',
});
  return (
    <div className="container mt-5c">
      <Form setFormData={setFormData} formData={formData}/>
      <div className="mt-4 p-3 border rounded bg-light shadow">
            <ul className="list-group">
            <li className="list-group-item">
                <strong>First Name:</strong> {formData.firstName}
            </li>
            <li className="list-group-item">
                <strong>Last Name:</strong> {formData.lastName}
            </li>
            <li className="list-group-item">
                <strong>Email:</strong> {formData.email}
            </li>
            <li className="list-group-item">
                <strong>Password:</strong> {formData.password}
            </li>
            <li className="list-group-item">
                <strong>Confirm Password:</strong> {formData.confirmPassword}
                </li>
            </ul>
        </div>
    </div>
  );
}

export default App;

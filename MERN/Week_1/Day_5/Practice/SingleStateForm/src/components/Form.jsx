import React, { useState } from 'react';

    const Form = ({formData, setFormData}) => {
    
    const handleChange = (e) => {
        
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData, 
            [name]: value, 
        
        
        
        }));        
    };

    return (
        <form className="border p-4 rounded bg-light shadow">
            <h3 className="mb-4">Form with Single State Object</h3>
            <div className="mb-3">
            <label className="form-label">
            First Name:
            </label>
            <input
                type="text"
                name="firstName"
                id="firstName"
                className="form-control"
                value={formData.firstName}
                onChange={handleChange}
            />
            </div>

            <div className="mb-3">
            <label htmlFor="lastName" className="form-label">
                Last Name:
            </label>
            <input
                type="text"
                name="lastName"
                id="lastName"
                className="form-control"
                value={formData.lastName}
                onChange={handleChange}
            />
            </div>
            <div className="mb-3">
            <label htmlFor="email" className="form-label">
                Email:
            </label>
            <input
                type="email"
                name="email"
                id="email"
                className="form-control"
                value={formData.email}
                onChange={handleChange}
            />
            </div>
            <div className="mb-3">
            <label htmlFor="password" className="form-label">
                Password:
            </label>
            <input
                type="password"
                name="password"
                id="password"
                className="form-control"
                value={formData.password}
                onChange={handleChange}
            />
            </div>
            <div className="mb-3">
            <label htmlFor="confirmPassword" className="form-label">
                Confirm Password:
            </label>
            <input
                type="password"
                name="confirmPassword"
                id="confirmPassword"
                className="form-control"
                value={formData.confirmPassword}
                onChange={handleChange}
            />
            </div>
        </form>
    );
    };

export default Form;

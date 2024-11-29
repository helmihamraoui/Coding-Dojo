import React, { useState } from 'react';

const Forms = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [userList, setUserList] = useState([]);
    const [errors, setErrors] = useState({});
    const [isSuccess, setIsSuccess] = useState(false);
    
    const validateForm = () => {
        
        let formErrors = {};
        let isValid = true;
        if (firstName.length < 2) {
            formErrors.firstName = 'First name needs to be more than 2 characters';
            isValid = false;
        }
        if (lastName.length < 2) {
            formErrors.lastName = 'Last name needs to be more than 2 characters';
            isValid = false;
        }
        if (email.length < 8) {
            formErrors.email = 'Email needs to be more than 8 characters';
            isValid = false;
        }
        if (password.length < 8) {
            formErrors.password = 'Password needs to be more than 8 characters';
            isValid = false;
        }
        if (password !== confirmPassword) {
            formErrors.confirmPassword = 'Confirm password does not match';
            isValid = false;
        }
        setErrors(formErrors);
        
        return isValid;
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // console.log(validateForm());
        if (validateForm()) {

            const newUser = {
                firstName,
                lastName,
                email
            };
            console.log(newUser);
            console.log(userList);
            
            setUserList([...userList, newUser]);
            setIsSuccess(true);
            setFirstName("")
            setLastName("")
            setEmail("")
            setPassword("")
            setConfirmPassword("")
        }
    };
    return (
        <div className='container'>
            <h1 className='TitleForm'>Welcome, Please submit the form</h1>
            <form className='Form' onSubmit={handleSubmit}>
                <div className="input-group input-group-sm">
                    <label htmlFor="firstName">First Name</label>
                    <input type="text" placeholder="first name" onChange={(e) => validateForm(setFirstName(e.target.value)) } value={firstName}/>
                    { <p className="error">{errors.firstName}</p>}
                </div>
                <div className="input-group input-group-sm">
                    <label htmlFor="lastName">Last Name</label>
                    <input type="text" placeholder="last name" onChange={(e) => validateForm(setLastName(e.target.value))} value={lastName} />
                    { <p className="error">{errors.lastName}</p>}
                </div>
                <div className="input-group input-group-sm">
                    <label htmlFor="email">Email Address</label>
                    <input type='email'placeholder="email address"  onChange={(e) => validateForm(setEmail(e.target.value))} value={email}/>
                    { <p className="error">{errors.email}</p>}
                </div>
                <div className="input-group input-group-sm">
                    <label htmlFor="password">Password</label>
                    <input type="password" placeholder="password"    onChange={(e) => validateForm(setPassword(e.target.value))} value={password} />
                    { <p className="error">{errors.password}</p>}
                </div>
                <div className="input-group input-group-sm">
                    <label htmlFor="confirmPassword">Confirm Password</label>
                    <input type="password" placeholder="confirm password" onChange={(e) => validateForm(setConfirmPassword(e.target.value))} value={confirmPassword} />
                    { <p className="error">{errors.confirmPassword}</p>}
                </div>
                <button>Create User</button>
            </form>
            {isSuccess && (
                <div className="success-message">
                    <h2>Thank you for submitting the form!</h2>
                </div>
            )}
            <div className="users-list">
                <h3>Users</h3>
                <ul>
                    {userList.map((user, index) => (
                        <li key={index}>
                            <span>{user.firstName} {user.lastName}</span> - ({user.email})
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default Forms;

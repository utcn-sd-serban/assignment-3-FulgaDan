import React from 'react';

const Login = ({username, password, onLogin, onChange}) => (
<div>
    <h1 className = "title">Welcome to the login module!</h1>
    <h2 className = "subtitle">Please enter your credentials</h2>
    <div className = "field">
        <label className = "label">Username</label>
        <div className = "control">
            <input className = "input" type = "text" placeholder= "e.g Alex Smith" value = {username} onChange = 
                                                                        { e => onChange("username", e.target.value)} />
        </div>  
    </div>
    
    <div className = "field">
        <label className = "label">Password</label>
        <div className = "control">
            <input className = "input" type = "text" placeholder= "text input" value = {password} onChange = 
                                                                        { e => onChange("password", e.target.value)} />
        </div>  
    </div>

    <div className="field is-grouped">
        <div className="control">
            <button className="button is-link" onClick = {onLogin}>Submit</button>
        </div>
        <div className="control">
            <button className="button is-text">Cancel</button>
        </div>
    </div>
</div>
);
export default Login;
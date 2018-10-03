import React, { Component } from 'react';
import Error from './Error';

export default class LoginForm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: '',
            password: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.checkIsFormValid = this.checkIsFormValid.bind(this);
    }

    checkIsFormValid() {
        let errorMessage = '';
        let isValid = false;

        if (this.state.email === '') {
            errorMessage = "Email field is empty!";
        } else if (this.state.password === '') {
            errorMessage = "Password field is empty!";
        } else {
            isValid = true;
        }

        return { errorMessage: errorMessage, isValid: isValid };
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    handleSubmit(event) {
        event.preventDefault();

        if (this.checkIsFormValid().isValid) {
            fetch(
                'http://localhost:5000/auth/login',
                {
                    method: 'POST',
                    body: JSON.stringify(this.state),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
            ).then(data => data.json())
                .then(res => {
                    if (res.success && res.token) {
                        res.success && sessionStorage.setItem('authtoken', res.token);
                        this.props.setLoggedIn();
                    }
                });
        }
    }

    render() {
        let errorMsg = '';

        if (!this.checkIsFormValid().isValid) {
            errorMsg = (<div className="error">
                <Error msg={this.checkIsFormValid().errorMessage} />
            </div>)
        }

        return (
            <div>
                <p>Login</p>
                {errorMsg}
                <form onSubmit={this.handleSubmit}>
                    <label>Email:
                    <input name="email" type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label>Password:
                    <input name="password" type="password" onChange={this.handleChange} />
                    </label>
                    <br />
                    <input type="submit" onSubmit={this.handleSubmit} />
                </form>
            </div>
        );
    }
}


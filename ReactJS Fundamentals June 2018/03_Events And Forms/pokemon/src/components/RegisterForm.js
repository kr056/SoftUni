import React, { Component } from 'react';
import Error from './Error';

export default class RegisterForm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: '',
            confirmedEmail: '',
            name: '',
            password: '',
            confirmedPassword: '',
            termsBox: false
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
        } else if (this.state.confirmedEmail !== this.state.email) {
            errorMessage = "Confirmed email does not match email!";
        } else if (this.state.name === '') {
            errorMessage = "Username field is empty!";
        } else if (this.state.password.length < 8) {
            errorMessage = "Password should be atleast 8 symbols!";
        } else if (this.state.confirmedPassword !== this.state.password) {
            errorMessage = "Confirmed password does not match password!";
        } else if (this.state.termsBox === false) {
            errorMessage = "You have to agree with the terms!";
        } else {
            isValid = true;
        }

        return { errorMessage: errorMessage, isValid: isValid };
    }

    handleChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    handleSubmit(event) {
        event.preventDefault();

        if(this.checkIsFormValid().isValid){
            fetch(
                'http://localhost:5000/auth/signup',
                {
                    method: 'POST',
                    body: JSON.stringify({ email: this.state.email, name: this.state.name, password: this.state.password }),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
            ).then(data => data.json())
                .then(res => {
                    console.log(res);
                    this.props.setSignedUp();
                })
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
                <p>Sign Up</p>
                {errorMsg}
                <form onSubmit={this.handleSubmit}>
                    <label>Email:
                    <input name="email" type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label>Confirm Email:
                    <input name="confirmedEmail" type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label>Username:
                    <input name="name" type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label>Password:
                    <input name="password" type="password" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label>Confirm Password:
                    <input name="confirmedPassword" type="password" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label>I agree with the terms
                    <input name="termsBox" type="checkbox" onChange={this.handleChange} />
                    </label>
                    <br />
                    <input type="submit" onSubmit={this.handleSubmit} />
                </form>
            </div>
        );
    }
}


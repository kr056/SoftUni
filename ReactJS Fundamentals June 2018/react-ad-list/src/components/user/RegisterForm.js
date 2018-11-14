import React, { Component } from 'react'
import userService from '../../api/services/userService'
import userValidator from '../../api/validators/userValidator'
import observer from '../../api/observer'


export default class RegisterForm extends Component {
    constructor(props) {
        super(props)

        this.state = {
            username: '',
            password: '',
            confirmedPassword: ''
        }

        this.handleChange = this.handleChange.bind(this)
        this.handleSumbit = this.handleSumbit.bind(this)
    }

    handleChange(e) {
        let fieldName = e.target.name
        let fieldValue = e.target.value

        this.setState({ [fieldName]: fieldValue })
    }

    handleSumbit(e) {
        e.preventDefault()

        observer.trigger(observer.events.notification, { type: 'loading', message: 'Loading...' })

        if (!(userValidator.validateRegister(this.state))) {
            return
        }

        let userData = {
            username: this.state.username,
            password: this.state.password
        }

        userService.register(userData)
            .then(res => {
                observer.trigger(observer.events.notification, { type: 'success', message: 'Register successful.' })
                observer.trigger(observer.events.loginUser, userData.username)
                sessionStorage.setItem('authtoken', res._kmd.authtoken)
                sessionStorage.setItem('userId', res._id)
                this.setState({ username: '', password: '', confirmedPassword: '' })
                this.props.history.push('/')
            }).catch(res => {
                observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
            })
    }

    render() {
        return (
            <form onSubmit={this.handleSumbit}>
                <div className="form-group col-md-4">
                    <label>Username</label>
                    <input name="username" type="text" className="form-control" placeholder="Enter Username" onChange={this.handleChange} />
                </div>
                <div className="form-group col-md-4">
                    <label>Password</label>
                    <input name="password" type="password" className="form-control" placeholder="Enter Password" onChange={this.handleChange} />
                </div>
                <div className="form-group col-md-4">
                    <label>Confrim Password</label>
                    <input name="confirmedPassword" type="password" className="form-control" placeholder="Enter Password" onChange={this.handleChange} />
                </div>
                <input type="submit" value="Register" />
            </form >
        )
    }
}
import React, { Component } from 'react'
import userService from '../../api/services/userService'
import observer from '../../api/observer'

export default class Logout extends Component {
    logout = () => {
        userService.logout()
            .then(() => {
                sessionStorage.removeItem('authtoken')
                sessionStorage.removeItem('userId')

                observer.trigger(observer.events.notification, { type: 'success', message: 'Logout successful.' })
                this.props.history.push('/')
            }).catch(res => {
                observer.trigger(observer.events.notification,
                    { type: 'error', message: res.responseJSON.description })
                    
                this.props.history.push('/')

            })
    }

    render() {
        this.logout()
        return (
            <div></div>
        )
    }
}
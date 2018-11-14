import React, { Component } from 'react'
import observer from '../../api/observer'
import '../../styles/notification.css'

const DEFAULT_STATE = {
    type: '',
    message: '',
    hide: true
}

export default class Notification extends Component {
    constructor() {
        super()

        this.state = DEFAULT_STATE

        observer.subscribe(observer.events.notification, this.showNotification.bind(this))
        this.hideNotification = this.hideNotification.bind(this)
    }

    showNotification(data) {
        let message = data.message
        let type = data.type
        
        this.setState({ type, message, hide: false })
    }

    hideNotification() {
        this.setState(DEFAULT_STATE)
    }

    render() {
        let notificationId
        let className
        
        if (this.state.type === 'success') {
            notificationId = 'successBox'
            className = "alert alert-success"
            // hide notification after 3 seconds
            setTimeout(this.hideNotification, 3000)
        } else if (this.state.type === 'error') {
            notificationId = 'errorBox'
            className = "alert alert-danger"
        } else if (this.state.type === 'loading') {
            notificationId = 'loadingBox'
            className = "alert alert-info"
        }
        return (this.state.hide ? null
            : (<div id='notifications' onClick={this.hideNotification}>
                <div id={notificationId} className={className} role="alert">
                    <span>{this.state.message}
                    </span>
                </div>
            </div>)
        )
    }
}


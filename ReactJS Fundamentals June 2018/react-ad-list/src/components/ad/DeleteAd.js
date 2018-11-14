import React, { Component } from 'react'
import adService from '../../api/services/adService'
import userService from '../../api/services/userService'
import observer from '../../api/observer'

export default class DeleteAd extends Component {
    delete = (props) => {
        //check if user can delete ad
        let roleId = ''
        let userId = sessionStorage.getItem('userId')
        
        if (userId) {
            userService.getUser(userId).then(res => {
                if (res._kmd.roles) {
                    roleId = res._kmd.roles[0].roleId
                }
            }).catch(res => {
                console.log(res)
            })
        }
        
        let adId = this.props.match.params.id

        adService.getAdForOperations(adId)
            .then(res => {
                if (res._acl.creator === sessionStorage.getItem('userId') || roleId!=='') {
                    adService.deleteAd(adId)
                        .then(res => {
                            observer.trigger(observer.events.notification, { type: 'success', message: 'Deleted Ad!' })
                            this.props.history.push('/')
                        }).catch(res => {
                            observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
                            this.props.history.push('/')
                        })
                } else {
                    observer.trigger(observer.events.notification, { type: 'error', message: 'You are not allowed to delete ads!' })
                    this.props.history.push('/')
                }
            }).catch(res => {
                observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
                this.props.history.push('/')
            })
    }

    render() {
        this.delete()

        return (
            <div></div>
        )
    }
}
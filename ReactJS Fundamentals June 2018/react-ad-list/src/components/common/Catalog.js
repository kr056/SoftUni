import React, { Component } from 'react'
import adService from '../../api/services/adService'
import Ad from '../ad/Ad'
import AdminView from '../admin/AdminView'
import userService from '../../api/services/userService';
import observer from '../../api/observer'

export default class Catalog extends Component {
    constructor(props) {
        super(props)

        this.state = { ads: [] }
    }


    componentDidMount() {
        //user guestLogin function to pull collection from kinvey
        if (sessionStorage.getItem('authtoken') === null) {
            userService.guestLogin().then(res => {
                sessionStorage.setItem('authtoken', res._kmd.authtoken)
                adService.getAds().then(res => {
                    this.setState({ ads: res })
                }).catch(res => {
                    observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
                })
            }).catch(res => {
                observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
            })
        } else {
            //load collection from kinvey for normal user
            adService.getAds().then(res => {
                this.setState({ ads: res })
            }).catch(res => {
                observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
            })
        }
    }

    render() {
        return (
            <div>
                <AdminView />
                <div id="allAds" className="container">
                    <div className="row">
                        {this.state.ads.map(a => <Ad key={a._id} {...a} />)}
                    </div>
                </div>
            </div>
        )
    }
}
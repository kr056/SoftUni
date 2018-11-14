import React, { Component } from 'react'
import adService from '../../api/services/adService'
import Ad from '../ad/Ad'
import observer from '../../api/observer'

export default class Profile extends Component {
    constructor(props) {
        super(props)

        this.state = { ads: [] }
    }


    componentDidMount() {
        //load user ads
        let userId = sessionStorage.getItem('userId')
        
        adService.getUserAds({_acl:{creator:userId}}).then(res => {
            this.setState({ ads: res })
        }).catch(res => {
            observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
        })
    }

    render() {
        if(this.state.ads.length===0){
            return (
                <div id="userAds" className="container">
                    <h3>You have not created ads still</h3>
                </div>
            )
        }
        return (
            <div id="userAds" className="container">
                <h3>My Ads</h3>
                <div className="row">
                    {this.state.ads.map(a => <Ad key={a._id} {...a} />)}
                </div>
            </div>
        )
    }
}
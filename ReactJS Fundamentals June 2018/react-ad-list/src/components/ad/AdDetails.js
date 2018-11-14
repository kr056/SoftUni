import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import adService from '../../api/services/adService'
import userService from '../../api/services/userService'
import observer from '../../api/observer'

export default class AdDetails extends Component {
    constructor(props) {
        super(props)

        this.state = {}
    }

    componentDidMount() {
        //get ad details
        let adId = this.props.match.params.id

        adService.getAdDetails({ _id: adId }).then(res => {
            this.setState({ ad: res[0] })
        }).catch(res => {
            observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
        })

        //check if user is in admin role
        let userId = sessionStorage.getItem('userId')
        
        if (userId) {
            userService.getUser(userId).then(res => {
                if (res._kmd.roles) {
                    this.setState({ roleId: res._kmd.roles[0].roleId })
                }
            }).catch(res => {
                console.log(res)
            })
        }
    }

    render() {
        let canEdit
        let canDelete
        if (!this.state.ad) {
            return <div>Loading...</div>
        } else {
            canEdit = <Link className="btn btn-warning" to={'/ad/edit/' + this.state.ad._id}>Edit</Link>
            canDelete = <Link className="btn btn-danger" to={'/ad/delete/' + this.state.ad._id}>Delete</Link>
        }
        return (
            <div className="details-container">
                <div className="row">
                    <div id="adDetails" className="col-xs-4 mx-auto">
                        <img src={this.state.ad.image} alt="sth" />
                        <h2>{this.state.ad.title}</h2>
                        <p>Condition: {this.state.ad.condition}</p>
                        <p>Category: {this.state.ad.category}</p>
                        <p>Description: {this.state.ad.description}</p>
                        <div className="btn-toolbar" role="toolbar">
                            <div className="btn-group mr-2">
                                {(this.state.ad._acl.creator === sessionStorage.getItem('userId')
                                    || this.state.roleId !== undefined) ? canEdit : null}
                            </div>
                            <div className="btn-group mr-2">
                                {(this.state.ad._acl.creator === sessionStorage.getItem('userId')
                                    || this.state.roleId !== undefined) ? canDelete : null}
                            </div>
                        </div>
                    </div>
                    <div id="adAuthorDetails" className="col-xs-1">
                        <button type="button" className="btn btn-default">Price: {this.state.ad.price} BGN</button>
                        <br /><br />
                        <button type="button" className="btn btn-primary">Author: {this.state.ad.authorName}</button>
                        <br /><br />
                        <button type="button" className="btn btn-primary">Phone: {this.state.ad.authorPhone}</button>
                        <br /><br />
                        <button type="button" className="btn btn-primary">City: {this.state.ad.authorCity}</button>
                    </div>
                </div>
            </div>
        )
    }
}
import React, { Component } from 'react'
import adService from '../../api/services/adService'
import userService from '../../api/services/userService'
import adValidator from '../../api/validators/adValidator'
import observer from '../../api/observer'

export default class EditAd extends Component {
    constructor(props) {
        super(props)

        this.state = {
            title: '',
            categories: [],
            category: '',
            condtion: '',
            price: '',
            image: '',
            description: '',
            authorName: '',
            authorCity: '',
            authorPhone: '',
        }

        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
    }

    handleChange(e) {
        let fieldName = e.target.name
        let fieldValue = e.target.value

        this.setState({ [fieldName]: fieldValue })
    }

    handleSubmit(e) {
        e.preventDefault()

        observer.trigger(observer.events.notification, { type: 'loading', message: 'Loading...' })

        if (!(adValidator.validateAd(this.state))) {
            return
        }

        let adId = this.props.match.params.id;

        adService.editAd(adId, this.state).then(res => {
            this.props.history.push('/')
            observer.trigger(observer.events.notification, { type: 'success', message: 'Edited Ad!' })
        }).catch(res => {
            observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
        })
    }

    componentDidMount() {
        //check if user can edit ad and load info in form
        let userId = sessionStorage.getItem('userId')

        if (userId) {
            userService.getUser(userId).then(res => {
                if (res._kmd.roles) {
                    this.setState({ ['roleId']: res._kmd.roles[0].roleId })
                    let adId = this.props.match.params.id;
                    adService.getAdForOperations(adId).then(res => {
                        if (res._acl.creator === sessionStorage.getItem('userId') || this.state.roleId !== undefined) {
                            this.setState({ ...res })
                        } else {
                            this.props.history.push('/')
                            observer.trigger(observer.events.notification, { type: 'error', message: 'You are not allowed to edit ads!' })
                        }
                    }).catch(res => {
                        this.props.history.push('/')
                        observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
                    })
                }else{
                    let adId = this.props.match.params.id;
                    
                    adService.getAdForOperations(adId).then(res => {
                        if (res._acl.creator === sessionStorage.getItem('userId') || this.state.roleId !== undefined) {
                            this.setState({ ...res })
                        } else {
                            this.props.history.push('/')
                            observer.trigger(observer.events.notification, { type: 'error', message: 'You are not allowed to edit ads!' })
                        }
                    }).catch(res => {
                        this.props.history.push('/')
                        observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
                    })
                }
            }).catch(res => {
                console.log(res)
            })
        }
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label>Title</label>
                        <input name="title" type="text" onChange={this.handleChange} className="form-control" value={this.state.title} />
                    </div>
                    <div className="form-group col-md-4">
                        <label>Category</label>
                        <select name="category" value={this.state.category} onChange={this.handleChange} className="form-control" >
                            {this.state.categories && this.state.categories.map((c, i) => <option key={i} value={c}>{c}</option>)}
                        </select>
                    </div>

                </div>
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label>Condition</label>
                        <select onChange={this.handleChange} value={this.state.condition} name="condition" className="form-control">
                            <option value="New">New</option>
                            <option value="Used">Used</option>
                        </select>
                    </div>
                    <div className="form-group col-md-4">
                        <label>Price</label>
                        <input name="price" type="number" onChange={this.handleChange} className="form-control" value={this.state.price} />
                    </div>
                </div>
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label>Image</label>
                        <input name="image" onChange={this.handleChange} type="text" className="form-control" value={this.state.image} />
                    </div>
                    <div className="form-group col-md-4">
                        <label>Description</label>
                        <textarea name="description" onChange={this.handleChange} className="form-control" rows="3" value={this.state.description} />
                    </div>
                </div>

                <h1>Contact Data</h1>

                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label>Author Name</label>
                        <input name="authorName" onChange={this.handleChange} type="text" className="form-control" value={this.state.authorName} />
                    </div>

                    <div className="form-group col-md-4">
                        <label>Author City</label>
                        <input name="authorCity" onChange={this.handleChange} type="text" className="form-control" value={this.state.authorCity} />
                    </div>
                </div>

                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label>Author Phone Number</label>
                        <input name="authorPhone" onChange={this.handleChange} type="text" className="form-control" value={this.state.authorPhone} />
                    </div>
                </div>
                <input type="submit" value="Edit Ad" />
            </form >
        )
    }
}
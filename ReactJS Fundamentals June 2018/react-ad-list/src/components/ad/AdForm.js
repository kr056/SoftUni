import React, { Component } from 'react'
import categoryService from '../../api/services/categoryService'
import adService from '../../api/services/adService'
import adValidator from '../../api/validators/adValidator'
import observer from '../../api/observer'

export default class AdForm extends Component {
    constructor(props) {
        super(props)

        this.state = {
            category:'Other',
            condition:'New'
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

        let data = this.state
        console.log(data)

        //validate form
        if (!(adValidator.validateAd(data))) {
            return
        }

        //create ad
        adService.createAd(data)
            .then(res => {
                observer.trigger(observer.events.notification, { type: 'success', message: 'Created Ad successfully.' })

                this.setState({})
                this.props.history.push('/')
            }).catch(res => {
                observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
            })

    }

    componentDidMount() {
        //load categories in form
        categoryService.getCategories().then(res => {
            this.setState({ 'categories': res.map(e => e.categoryName) })
        })
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label>Title</label>
                        <input name="title" type="text" onChange={this.handleChange} className="form-control" placeholder="Enter Title" />
                    </div>
                    <div className="form-group col-md-4">
                        <label>Category</label>
                        <select name="category" value={this.state.category} onChange={this.handleChange} className="form-control" >
                            {this.state.categories && this.state.categories.map((c,i) =><option key={i} value={c}>{c}</option>)}
                        </select>
                    </div>

                </div>
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label>Condition</label>
                        <select onChange={this.handleChange} value={this.state.condition}  name="condition" className="form-control">
                            <option value="New">New</option>
                            <option value="Used">Used</option>
                        </select>
                    </div>
                    <div className="form-group col-md-4">
                        <label>Price</label>
                        <input name="price" type="number" onChange={this.handleChange} className="form-control" placeholder="Enter Price" />
                    </div>
                </div>
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label>Image</label>
                        <input name="image" onChange={this.handleChange} type="text" className="form-control" placeholder="Enter Image URL" />
                    </div>
                    <div className="form-group col-md-4">
                        <label>Description</label>
                        <textarea name="description" onChange={this.handleChange} className="form-control" rows="3" placeholder="Write something more about the product" />
                    </div>
                </div>

                <h1>Contact Data</h1>

                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label>Author Name</label>
                        <input name="authorName" onChange={this.handleChange} type="text" className="form-control" placeholder="Enter Your Name" />
                    </div>

                    <div className="form-group col-md-4">
                        <label>Author City</label>
                        <input name="authorCity" onChange={this.handleChange} type="text" className="form-control" placeholder="Enter Author City" />
                    </div>
                </div>

                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label>Author Phone Number</label>
                        <input name="authorPhone" onChange={this.handleChange} type="number" className="form-control" placeholder="Enter Phone Number" />
                    </div>
                </div>
                <input type="submit" value="Create Ad" />
            </form >
        )
    }
}
import React, { Component } from 'react'
import categoryService from '../../api/services/categoryService'
import categoryValidator from '../../api/validators/categoryValidator'
import observer from '../../api/observer'

export default class CategoryForm extends Component {
    constructor(props) {
        super(props)

        this.state = { categoryName: '' }

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

        if (!(categoryValidator.validateCategory(data))) {
            return
        }

        categoryService.createCategory(data)
            .then(res => {
                observer.trigger(observer.events.notification, { type: 'success', message: 'Created Category successfully.' })

                this.setState({ categoryName: '' })
                this.props.history.push('/')
            }).catch(res => {
                console.log(res)
                observer.trigger(observer.events.notification, { type: 'error', message: res.responseJSON.description })
            })

    }
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-group col-md-4">
                    <label>Category</label>
                    <input name="categoryName" type="text" className="form-control" onChange={this.handleChange} placeholder="Enter Category" />
                </div>
                <input type="submit" value="Add Category" />
            </form >
        )
    }
}
import React, { Component } from 'react'
import { NavLink } from 'react-router-dom'
import userService from '../../api/services/userService'
import categoryService from '../../api/services/categoryService'
import observer from '../../api/observer'

export default class AdminView extends Component {
    constructor(props) {
        super(props)

        this.state = {
            roleId: '',
            categories: [],
        }

        this.handleCategoryChange = this.handleCategoryChange.bind(this)
        this.deleteCategory = this.deleteCategory.bind(this)
    }

    componentDidMount() {
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
        categoryService.getCategories().then(res => {
            this.setState({ ['categories']: res })
        })
    }

    handleCategoryChange(e) {
        let fieldName = e.target.name
        let fieldValue = e.target.value

        this.setState({ [fieldName]: fieldValue })
    }

    deleteCategory(categoryId) {
        //if delete button is clicked admin deletes the category
        if (categoryId !== undefined) {
            categoryService.deleteCategory(categoryId).then(res => {
                observer.trigger(observer.events.notification, { type: 'success', message: 'Deleted Category' })
            }).catch(res => {
                observer.trigger(observer.events.notification, { type: 'error', message: 'You are not allowed to delete categories!' })
            })
        }else{
            observer.trigger(observer.events.notification, { type: 'error', message: 'Chose the category you want to delete!' })
        }
    }

    render() {
        if (this.state.roleId === '') {
            return null
        }
        return (
            <div className="jumbotron">
                <h1 className="display-4">Admin View</h1>
                <div className="row">
                    <div className="btn-toolbar" role="toolbar">
                        <div className="btn-group mr-2">
                            <NavLink to="/ad/create" className="btn btn-primary">Create Ad</NavLink>
                        </div>
                        <div className="btn-group mr-2">
                            <NavLink to="/category/create" className="btn btn-primary">Create Category</NavLink>
                        </div>
                    </div>
                    <div className="btn-toolbar" role="toolbar">
                        <div className="btn-group mr-2">
                            <button onClick={() => this.deleteCategory(this.state.category)} className="btn btn-danger">Delete Category</button>
                        </div>
                    </div>
                    <div id="categoriesSelect" className="col-sm">
                        <select name="category" onChange={this.handleCategoryChange} value={this.state.category}>
                            {this.state.categories && this.state.categories.map((c) => <option key={c._id} value={c._id}>{c.categoryName}</option>)}
                        </select>
                    </div>
                </div>
            </div>
        )
    }
}
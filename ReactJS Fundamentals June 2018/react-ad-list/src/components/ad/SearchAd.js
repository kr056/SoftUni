import React, { Component } from 'react'
import SeacrResult from './SearchResult'
import adService from '../../api/services/adService'

export default class SearchAd extends Component {
    constructor(props) {
        super(props)

        this.state = {}

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

        //get ads by search input
        adService.getAdsByCategory(this.state.category)
            .then(res => {
                this.setState({ ads: res })
            }).catch(res => {
                console.log(res)
            })
    }


    render() {
        if (this.state.ads) {
            return (
                <div>
                    <form onSubmit={this.handleSubmit} className="form-inline my-2 my-lg-0">
                        <input onChange={this.handleChange} name="category" className="form-control mr-sm-2" placeholder="i.e Fashion,Mobiles,Furniters" aria-label="Search" />
                        <input type="submit" value="Search" />
                    </form>
                    <SeacrResult ads={this.state.ads} />
                </div>
            )
        }
        return (
            <form onSubmit={this.handleSubmit} className="form-inline my-2 my-lg-0">
                <input onChange={this.handleChange} name="category" className="form-control mr-sm-2" placeholder="i.e Fashion,Mobiles,Furniters" aria-label="Search" />
                <input type="submit" value="Search" />
            </form>
        )
    }
}
import React, { Component } from 'react'
import { Link } from 'react-router-dom'

export default class Ad extends Component {
    render() {
        return (
            <div className="col-md-3">
                <div className="card mb-3 box-shadow">
                    <img className="card-img-top" src={this.props.image} alt="sth" />
                    <div className="card-body">
                        <h5>{this.props.title}</h5>
                        <div className="d-flex justify-content-between align-items-center">
                            <div className="btn-group">
                                <Link className="btn btn-sm btn-outline-secondary" to={'/ad/details/' + this.props._id}>Details</Link>
                            </div>
                            <h5>{this.props.price} BGN</h5>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
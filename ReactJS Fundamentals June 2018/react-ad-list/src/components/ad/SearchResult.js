import React, { Component } from 'react'
import Ad from './Ad'

export default class SearchResults extends Component {
    render() {
        if (this.props.ads.length>0) {
            return (
                <div id="searchAds">
                    <div className="row">
                        {this.props.ads.map(a => <Ad key={a._id} {...a} />)}
                    </div>
                </div>
            )
        }
        return (
            <h3>No Results</h3>
        )
    }
}
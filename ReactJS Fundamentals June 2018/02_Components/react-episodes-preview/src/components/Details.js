import React, { Component } from 'react';

class Details extends Component {
    render() {
        let content = this.props.bio ?
            (<div>
                <div>
                    <img src={this.props.url} alt="sth" />
                </div>
                <div>
                    Name:  {this.props.name}
                    <br />
                    <p>{this.props.bio}</p>
                </div>
            </div>)
            : (<h1>Select a character to see details</h1>);

        return (
            <section className="detailsContainer">
                {content}
            </section>
        );
    }
}

export default Details;
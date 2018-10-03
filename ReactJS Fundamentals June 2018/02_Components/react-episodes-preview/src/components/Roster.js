import React, { Component } from 'react';

class Roster extends Component {
    render() {
        const images = this.props.images.map(i => (
            <div key={i.id}>
                <img src={i.url} alt="noImg" onClick={() => this.props.select(i.id)} />
            </div>
        ));

        return (
            <section className="imageContainer">
                {images}
            </section>
        )
    }
}

export default Roster;
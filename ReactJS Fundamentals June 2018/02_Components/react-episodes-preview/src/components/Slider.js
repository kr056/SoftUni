import React, { Component } from 'react';
import leftImg from '../resources/left.png';
import rightImg from '../resources/right.png';
import fetcher from '../fetcher';

const IMAGE_URL = '/episodePreview/';

class Slider extends Component {
    constructor() {
        super();
        this.state = {
            id: 0,
            imageUrl: null
        };
    }

    fetchEpisode = (id) => {
        fetcher.get(IMAGE_URL + id,
            data => this.setState({
                id: data.id,
                imageUrl: data.url
            }));
    }

    componentDidMount = () => {
        this.fetchEpisode(this.state.id);
    }

    previousEpisode = () => {
        this.fetchEpisode(
            Number(this.state.id) - 1 < 0
                ? 0 : Number(this.state.id) - 1
        )
    }

    nextEpisode = () => {
        this.fetchEpisode(
            Number(this.state.id) + 1 > 2
                ? 2 : Number(this.state.id) + 1
        )
    }


    render() {
        return (
            <div>
                <div className="warper">
                    <img alt="nope" src={leftImg}
                        className="slider-elem slider-button case-left"
                        onClick={this.previousEpisode}
                    />
                    <img className="sliderImg slider-elem"
                        alt="focusedEp"
                        src={this.state.imageUrl}
                    />
                    <img alt="nope" src={rightImg}
                        className="slider-elem slider-button case-right"
                        onClick={this.nextEpisode}
                    />
                </div>
            </div>
        )
    }
}

export default Slider;
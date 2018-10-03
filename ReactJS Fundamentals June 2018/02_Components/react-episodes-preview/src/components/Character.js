import React, { Component } from 'react';
import Roster from './Roster';
import Details from './Details';
import fetcher from '../fetcher';

const ROSTER_URL = '/roster';
const DETAILS_URL = '/character/';

class Character extends Component {
    constructor(props) {
        super(props);

        this.state = {
            images: [],
            details: {
                id: null,
                name: null,
                url: null,
                bio: null
            }
        };

    }

    componentDidMount() {
        fetcher.get(ROSTER_URL, data => this.setState({
            images: data
        }));
    }

    fetchDetails = id => {
        fetcher.get(DETAILS_URL + id, data => this.setState({
            details: data
        }));
    }

    selectCharacter = id =>{
        this.fetchDetails(id);
    }

    render = () => {
        return (
            <div>
                <Roster images={this.state.images} select={this.selectCharacter} />
                <Details {...this.state.details} />
            </div>
        );
    }
}

export default Character;
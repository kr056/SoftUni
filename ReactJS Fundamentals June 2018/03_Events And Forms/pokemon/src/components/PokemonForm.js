import React, { Component } from 'react';

export default class PokemonForm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            name: '',
            image: '',
            info: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    handleSubmit(event) {
        event.preventDefault();

        fetch(
            'http://localhost:5000/pokedex/create',
            {
                method: 'POST',
                body: JSON.stringify(this.state),
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        ).then(data => data.json())
            .then(res=>{
                if(res){
                    this.props.updatePokemons(res);
                }
            })
    }

    render() {
        return (
            <div>
                <p>Create Pokemon</p>
                <form onSubmit={this.handleSubmit}>
                    <label>Pokemon Name:
                    <input name="name" type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label>Pokemon Image:
                    <input name="image" type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label>Pokemon Info:
                    <input name="info" type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <input type="submit" onSubmit={this.handleSubmit} />
                </form>
            </div>
        );
    }
}


import React, { Component } from 'react';
import PokemonForm from './PokemonForm';
import Pokemon from './Pokemon';

export default class LoggedInView extends Component {
    constructor(props) {
        super(props);

        this.state = {
            pokemonArr: []
        };

        this.updatePokemons=this.updatePokemons.bind(this);
    }

    

    updatePokemons(newPokemons){
        this.setState({pokemonArr:newPokemons});
    }

    componentDidMount() {
        fetch('http://localhost:5000/pokedex/pokedex')
            .then(data => data.json())
            .then(response => this.setState({ pokemonArr: response.pokemonColection }));
    }

    render() {
        return (
            <div>
                <h3>Logged In!</h3>
                <PokemonForm updatePokemons={this.updatePokemons}/>
                {this.state.pokemonArr.map(
                    (poke,index) => <Pokemon  key={index} item={poke} />
                )}
            </div>
        );
    }
}


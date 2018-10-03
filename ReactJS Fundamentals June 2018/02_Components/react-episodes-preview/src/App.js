import React, { Component } from 'react';
import './App.css';
import Slider from './components/Slider';
import Character from './components/Character';

class App extends Component {
  render() {
    return (
      <div className="container">
        <Slider/>
        <Character />
      </div>
    );
  }
}

export default App;

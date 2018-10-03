import React, { Component } from 'react';
import Article from './components/Article';
import RegisterForm from './components/RegisterForm';
import Navigation from './components/Navigation';
import './styles/warning.css';

class App extends Component {
  render() {
    return (
      <div className="container">
        <Article />
        <RegisterForm />
        <Navigation />
      </div>
    );
  }
}

export default App;

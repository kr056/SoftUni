import React from 'react';
import logo from './logo.svg';
import './App.css';
import rerender from './index'

let counter = 0;

const incrementCounter = () => {
  counter++;
  rerender(Counter(), document.getElementById('root'));
}

const Counter = () => (
  <div className="App">
    <header className="App-header">
      <img src={logo} className="App-logo" alt="logo" />
      <h1 className="App-title">Welcome to React</h1>
    </header>
    <p>Counter: {counter}</p>
    <button onClick={incrementCounter}>Increment</button>
  </div>
);

export default Counter;

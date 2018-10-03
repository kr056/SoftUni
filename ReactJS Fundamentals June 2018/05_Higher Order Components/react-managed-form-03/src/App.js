import React, { Component } from 'react';
import BoundForm from './components/BoundForm';
import './App.css';

function onSubmit(data,e){
  console.log(data);
}

class App extends Component {
  render() {
    return (
      <div className="App">
        <h1>Hi</h1>
        <BoundForm onSubmit={onSubmit}>
          Username:
                <input name="username" type="text" /><br />
          Password:
                <input name="password" type="password" /><br />
          <input type="submit" value="Login" />
        </BoundForm >
      </div>
    );
  }
}

export default App;

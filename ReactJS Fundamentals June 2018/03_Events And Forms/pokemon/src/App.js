import React, { Component } from 'react';
import './App.css';
import RegisterForm from './components/RegisterForm';
import LoginForm from './components/LoginForm';
import LoggegInView from './components/LoggedInView';

class App extends Component {
  constructor(props) {
    super(props)

    let route = '';

    if (sessionStorage.getItem('authtoken')) {
      route = 'loggedIn';
    }

    this.state = { route: route };

    this.showAppropriateComponent = this.showAppropriateComponent.bind(this);
    this.switchLoginSignUp = this.switchLoginSignUp.bind(this);
    this.setLoggedIn = this.setLoggedIn.bind(this);
    this.setSignedUp = this.setSignedUp.bind(this);
    this.showRightText = this.showRightText.bind(this);
  }

  setLoggedIn() {
    this.setState({ route: 'loggedIn' });
  }

  setSignedUp() {
    this.setState({ route: 'login' });
  }

  showAppropriateComponent() {
    if (this.state.route === 'loggedIn') {
      return <LoggegInView />;
    }

    if (this.state.route === 'login') {
      return <LoginForm setLoggedIn={this.setLoggedIn} />;
    }
    
    return <RegisterForm setSignedUp={this.setSignedUp} />;
  }

  switchLoginSignUp() {
    if (this.state.route === 'login') {
      this.setState({ route: '' });
    } else {
      this.setState({ route: 'login' });
    }
  }

  showRightText() {
    if (this.state.route === 'login') {
      return <button onClick={this.switchLoginSignUp}>Go to Register</button>;
    } else if (this.state.route === '') {
      return <button onClick={this.switchLoginSignUp}>Go to Login</button>;
    }
  }

  render() {
    return (
      <div className="App" loggedin={window.sessionStorage.getItem('authToken')}>
        {this.showRightText()}
        {this.showAppropriateComponent()}
      </div>
    );
  }
}

export default App;

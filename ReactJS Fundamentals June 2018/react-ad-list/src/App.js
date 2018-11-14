import React, { Component } from 'react'
import Header from './components/common/Header'
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import Notification from './components/common/Notification'
import Footer from './components/common/Footer'
import LoginForm from './components/user/LoginForm'
import About from './components/common/About'
import Catalog from './components/common/Catalog'
import RegisterForm from './components/user/RegisterForm'
import Logout from './components/user/Logout'
import CategoryForm from './components/category/CategoryForm'
import AdForm from './components/ad/AdForm'
import Profile from './components/user/Profile'
import AdDetails from './components/ad/AdDetails'
import EditAd from './components/ad/EditAd'
import DeleteAd from './components/ad/DeleteAd'
import SearchAd from './components/ad/SearchAd'
import 'bootstrap/dist/css/bootstrap.css'
import './App.css'


class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <div className="App">
          <Header />
          <Notification />
          <Switch>
            <Route path="/user/login" component={LoginForm} />
            <Route path="/user/register" component={RegisterForm} />
            <Route path="/about" component={About} />
            <Route path="/search" component={SearchAd} />
            <Route path="/user/logout" component={Logout} />
            <Route path="/user/profile" component={Profile} />
            <Route path="/category/create" component={CategoryForm} />
            <Route path="/ad/create" component={AdForm} />
            <Route path="/ad/details/:id" component={AdDetails} />
            <Route path="/ad/edit/:id" component={EditAd} />
            <Route path="/ad/delete/:id" component={DeleteAd} />
            <Route path="/" component={Catalog} />
          </Switch>
          <Footer />
        </div>
      </BrowserRouter>
    );
  }
}

export default App

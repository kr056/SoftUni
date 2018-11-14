import React, { Component } from 'react'
import { NavLink } from 'react-router-dom'
import observer from '../../api/observer'

export default class Header extends Component {
    constructor(props) {
        super(props)

        this.state = { username: '' }

        observer.subscribe(observer.events.loginUser, this.userLoggedInUpdate.bind(this))

    }

    userLoggedInUpdate(username) {
        this.setState({ username })
    }

    render() {
        const notLoggedIn = <ul className="navbar-nav">
            <li className="nav-item">
                <NavLink to="/user/login" className="nav-link">
                    Login
                </NavLink>
            </li>
            <li className="nav-item">
                <NavLink to="/user/register" className="nav-link">
                    Register
                </NavLink>
            </li>
        </ul>
        const loggedIn =
            <ul className="navbar-nav">
                <li className="nav-item">
                    <NavLink to="/user/profile" className="nav-link">
                        {this.state.username}
                    </NavLink>
                </li>
                <li className="nav-item">
                    <a href="/user/logout" className="nav-link">
                        Logout
                    </a>
                </li>
            </ul>
        const canCreateAds = <li className="nav-item">
            <NavLink to="/ad/create" className="nav-link">Create Ad</NavLink>
        </li>
        return (
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <NavLink to="/" className="navbar-brand">AdList</NavLink>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item">
                            <NavLink to="/" className="nav-link">Catalog</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink to="/about" className="nav-link">About</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink to="/search" className="nav-link">Search</NavLink>
                        </li>
                        {this.state.username !== '' ? canCreateAds : null}
                    </ul>
                    {this.state.username !== '' ? loggedIn : notLoggedIn}
                </div>
            </nav >
        )
    }
}
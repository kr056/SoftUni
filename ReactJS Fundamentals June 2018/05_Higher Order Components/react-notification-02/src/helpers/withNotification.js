import React, { Component } from 'react';

export default function withNotification(WrappedComponent) {
    return class extends Component {
        constructor(props) {
            super(props);

            this.state = {               
                error: '',
                info: ''
            };
        }

        componentDidCatch(error, info) {
            this.setState({ error, info });
        }

        render() {
            if (this.state.info) {
                return (
                    <div className="error">
                        <p>{this.state.error.toString()}</p>
                        <p>{this.state.info.componentStack}</p>
                        <WrappedComponent />
                    </div>
                );
            }

            return (
                <WrappedComponent />
            );
        }
    }
}
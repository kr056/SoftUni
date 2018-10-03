import React, { Component } from 'react';

export default function withWarning(WrappedComponent) {
    return class extends Component {
        render() {
            return (
                <div className="alert">
                    <span className="alert-symbol">&#9888;</span>
                    <WrappedComponent />
                </div>
            );
        }
    }
}
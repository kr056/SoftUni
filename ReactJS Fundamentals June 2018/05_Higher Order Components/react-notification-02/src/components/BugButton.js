import React, { Component } from 'react';
import withNotification from '../helpers/withNotification';

class BugButtonBase extends Component {
    constructor(props) {
        super(props);

        this.state = {
            throw: false
        };

        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        this.setState({ throw: true });
    }


    render() {
        if (this.state.throw) {
            throw new Error('Told you');
        }

        return (
            <div>
                <button onClick={this.handleClick}>Do not click me!</button>
            </div>
        );
    }
}

const BugButton = withNotification(BugButtonBase);

export default BugButton;
import React, { Component } from 'react';
import CommentForm from '../comment/CommentForm';
import CommentsList from '../comment/CommentsList';

export default class PostComment extends Component {
    constructor(props) {
        super(props);

        this.state = {
            comments:[]
        };

        this.updateComments=this.updateComments.bind(this);
    }

    componentDidMount() {}

    updateComments(comments){
        this.setState({
            comments:comments
        });
    }

    render() {
        return (
            <section id="viewPostDetails">
                <CommentForm updateComments={this.updateComments} postId={this.props.postId} />
                <CommentsList comments={this.state.comments} updateComments={this.updateComments} postId={this.props.postId} />
            </section>
        );
    }
}
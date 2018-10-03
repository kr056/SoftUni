import React, { Component } from 'react';
import requester from '../../infrastructure/requester';
import Comment from './Comment';
import '../../styles/comment.css';

export default class CommentsList extends Component {
    getComments = () => {
        let query = 'comments/?query=' + JSON.stringify({ postId: this.props.postId })
        requester.get('appdata', query, 'kinvey')
            .then(res => {
                if (res) {
                    this.props.updateComments(res);
                }
            }).catch(err=>{
                console.log(err);
            });
    }

    componentDidMount() {
        this.getComments();
    }

    render() {
        if (!this.props.comments) {
            return <div>Loading...</div>;
        }

        return (
            <div id="allComments" className="comments">
                {Array.from(this.props.comments).map(c => <Comment key={c._id}  {...c} />)}
            </div>
        );

    }
}
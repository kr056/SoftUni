import React, { Component } from 'react';
import PostComment from '../comment/PostComment';
import Details from './Details';
import requester from '../../infrastructure/requester';
import '../../styles/post.css';

export default class PostDetails extends Component {
    constructor(props) {
        super(props);

        this.state = {};
    }

    componentDidMount() {
        let query = 'posts/?query=' + JSON.stringify({ _id: this.props.match.params.id });

        requester.get('appdata', query, 'kinvey')
            .then(res => {
                const post = res[0]
                this.setState({ post })
            }).catch(err=>{
                console.log(err);
            });
    }

    render() {
        if (!this.state.post) {
            return <div>Loading...</div>;
        }

        return (
            <section id="viewPostDetails">
                <Details {...this.state.post} />
                <PostComment postId={this.state.post._id} />
            </section>
        );
    }
}
import React, { Component } from 'react';
import requester from '../../infrastructure/requester';
import Post from './Post';

export default class PostsList extends Component {
    constructor(props) {
        super(props);

        this.state = { posts: [] };
    }

    getPosts = () => {
        requester.get('appdata', 'posts', 'kinvey')
            .then(res => {
                this.setState({ posts: res })
            }).catch(err=>{
                console.log(err);
            });
    }

    componentDidMount() {
        this.getPosts();
    }

    render() {
        return (
            <section id="viewCatalog">
                <div id="allForumPosts" className="posts">
                    {this.state.posts.map((p, i) => <Post key={p._id} index={i} {...p} />)}
                </div>
            </section>
        );
    }
}
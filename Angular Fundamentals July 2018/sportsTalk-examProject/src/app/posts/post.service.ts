import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PostCreateModel } from './models/post-create.model';
import { map } from 'rxjs/operators';
import { PostListModel } from './models/post-list.model';


const postsUrl = 'https://angular-sportstalk-cb363.firebaseio.com/posts';


@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  //create post
  createPost(postBody: PostCreateModel) {
    return this.http.post(`${postsUrl}.json`, postBody)
  }

  //get all posts
  getAllPosts() {
    return this.http.get(`${postsUrl}.json`)
      .pipe(map((res: Response) => {
        
        const ids = Object.keys(res);
        const posts: PostListModel[] = [];
        for (let id of ids) {
          posts.push(new PostListModel(id, res[id].postTitle,
            res[id].postImage, res[id].postContent,
            res[id].postCategory, res[id].postDate, res[id].postAuthor, res[id].postAuthorUid));
        }
        const sortedPosts = posts.sort((a, b) => b.postDate - a.postDate);
        return sortedPosts;
      }));
  }

  //get post by id
  getPostById(postId: string) {
    return this.http.get<PostListModel>(`${postsUrl}/${postId}.json`);
  }

  // category posts
  getPostByCategory(categoryName) {
    return this.http.get(`${postsUrl}.json?orderBy="postCategory"&equalTo="${categoryName}"`)
      .pipe(map((res: Response) => {

        const ids = Object.keys(res);
        const posts: PostListModel[] = [];
        for (let id of ids) {
          posts.push(new PostListModel(id, res[id].postTitle,
            res[id].postImage, res[id].postContent,
            res[id].postCategory, res[id].postDate, res[id].postAuthor, res[id].postAuthorUid));
        }
        return posts;
      }));
  }

  // user profile posts
  getPostByAuthorUid(authorUid) {
    return this.http.get(`${postsUrl}.json?orderBy="postAuthorUid"&equalTo="${authorUid}"`)
      .pipe(map((res: Response) => {

        const ids = Object.keys(res);
        const posts: PostListModel[] = [];

        for (let id of ids) {
          posts.push(new PostListModel(id, res[id].postTitle,
            res[id].postImage, res[id].postContent,
            res[id].postCategory, res[id].postDate, res[id].postAuthor, res[id].postAuthorUid));
        }
        return posts;
      }));
  }


  // post edit
  editPost(body) {
    return this.http.patch(`${postsUrl}.json`, body);
  }

  //deletes post
  deletePost(postId: string) {
    return this.http.delete<PostListModel>(`${postsUrl}/${postId}/.json`);
  }
}

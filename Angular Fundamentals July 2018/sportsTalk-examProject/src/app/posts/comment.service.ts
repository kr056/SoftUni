import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommentCreateModel } from './models/comment-create.model';
import { map } from 'rxjs/operators';
import { CommentListModel } from './models/comment-list.model';

const commentsUrl = 'https://angular-sportstalk-cb363.firebaseio.com/comments';


@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  //create comment for certain post
  createComment(postId, commentBody: CommentCreateModel) {
    return this.http.post(`${commentsUrl}/${postId}.json`, commentBody);
  }

  //get commnets by postId
  getCommentsByPostId(postId) {
    return this.http.get(`${commentsUrl}/${postId}.json`).pipe(map((res: Response) => {
      if (res !== null) {
        const ids = Object.keys(res);
        const comments: CommentListModel[] = [];
        for (let id of ids) {
          comments.push(new CommentListModel(id,res[id].commentContent,
            res[id].commentAuthorName, res[id].commentAuthorUid));
        }
        return comments;
      }
    }));
  }

  //delete comments related to post
  deleteCommentsIfPostIsDeleted(postId) {
    return this.http.delete(`${commentsUrl}/${postId}/.json`);
  }

  //deletes comment
  deleteComment(postId,commentId){
    return this.http.delete(`${commentsUrl}/${postId}/${commentId}.json`);
  }
}

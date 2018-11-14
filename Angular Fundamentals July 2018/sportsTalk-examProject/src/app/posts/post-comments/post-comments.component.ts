import { Component, OnInit, Input } from '@angular/core';
import { CommentCreateModel } from '../models/comment-create.model';
import { CommentService } from '../comment.service';
import { AuthService } from '../../auth/auth.service';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { CommentListModel } from '../models/comment-list.model';

@Component({
  selector: 'app-post-comments',
  templateUrl: './post-comments.component.html',
  styleUrls: ['./post-comments.component.css']
})
export class PostCommentsComponent implements OnInit {
  @Input() postId: string;
  bindingModel: CommentCreateModel;
  comments:Observable<CommentListModel[]>;

  constructor(private commentService: CommentService,
    private authService: AuthService,
    private toastr: ToastrService) {
    this.bindingModel = new CommentCreateModel('', '', '')
  }

  ngOnInit() {
    this.comments=this.commentService.getCommentsByPostId(this.postId);
  }

  createComment() {
    this.bindingModel.commentAuthorName = this.authService.getUserName();
    this.bindingModel.commentAuthorUid = this.authService.getUserId();
    this.commentService.createComment(this.postId, this.bindingModel).subscribe((data => {
      this.toastr.success('Comment Created!');
      this.comments=this.commentService.getCommentsByPostId(this.postId);
    }), (err) => {
      console.log(err)
      this.toastr.error('You should sign in to add comments!');
    })
  }

  // deleteComment(commentId){
  //   if(this.authService.isAdmin()){
  //     this.commentService.deleteComment(this.postId,commentId).subscribe(data=>{
  //         this.comments=this.commentService.getCommentsByPostId(this.postId);
  //         this.toastr.success('Comment Deleted!');
  //     })
  //   }else{
  //     this.toastr.error('You are not allowed to delete comments!');
  //   }
  // }

}

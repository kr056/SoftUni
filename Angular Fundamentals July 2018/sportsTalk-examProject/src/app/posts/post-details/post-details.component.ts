import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PostService } from '../post.service';
import { Observable } from 'rxjs';
import { PostListModel } from '../models/post-list.model';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../../auth/auth.service';
import { CommentService } from '../comment.service';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {
  selectedPost: Observable<PostListModel>;
  id: string;

  constructor(private route: ActivatedRoute,
    private postService: PostService,
    private router: Router,
    private toastr: ToastrService,
    private authService: AuthService,
    private commentService: CommentService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.selectedPost = this.postService.getPostById(this.id);
  }


  deletePost() {
    //check if user uid matches posts author uid so user can delete only their own posts
    this.postService.getPostById(this.id).subscribe(data => {
      const loggedUserUid = this.authService.getUserId();
      if (loggedUserUid === data.postAuthorUid) {
        this.postService.deletePost(this.id)
          .subscribe(data => {
            //delete comments related to the post
            this.commentService.deleteCommentsIfPostIsDeleted(this.id).subscribe(data => {

            })
            this.toastr.success('Post Deleted!')
            this.router.navigate(['/post/all']);
          },(err)=>{
            console.log(err);
          });
      } else {
        this.toastr.error('Not allowed!')
        this.router.navigate(['/post/all']);
      }
    })

  }

}

import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';
import { Observable } from 'rxjs';
import { PostListModel } from '../models/post-list.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post-user',
  templateUrl: './post-user.component.html',
  styleUrls: ['./post-user.component.css']
})
export class PostUserComponent implements OnInit {
  posts: Observable<PostListModel[]>;
  userId:string;

  constructor(private postService: PostService,
  private route:ActivatedRoute) { }

  //load user related posts
  ngOnInit() {
    this.userId=this.route.snapshot.params['id'];
    this.posts=this.postService.getPostByAuthorUid(this.userId);
  }

}

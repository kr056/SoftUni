import { Component, OnInit } from '@angular/core';
import { PostListModel } from '../models/post-list.model';
import { PostService } from '../post.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-post-all',
  templateUrl: './post-all.component.html',
  styleUrls: ['./post-all.component.css']
})
export class PostAllComponent implements OnInit {

  posts: Observable<PostListModel[]>;

  constructor(private postService: PostService) { }

  //load all posts
  ngOnInit() {
    this.posts=this.postService.getAllPosts();
  }

}

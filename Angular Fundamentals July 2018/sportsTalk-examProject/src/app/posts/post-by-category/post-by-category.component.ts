import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { PostListModel } from '../models/post-list.model';
import { PostService } from '../post.service';

@Component({
  selector: 'app-post-by-category',
  templateUrl: './post-by-category.component.html',
  styleUrls: ['./post-by-category.component.css']
})
export class PostByCategoryComponent implements OnInit {
  postsByCategory: Observable<PostListModel[]>;

  constructor(private route: ActivatedRoute,
    private postService: PostService) { }
  
  // load posts by category
  ngOnInit() {
    this.route.params.subscribe(info => {
      this.postsByCategory = this.postService.getPostByCategory(info.name);
    })
  }

}

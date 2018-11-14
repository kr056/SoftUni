import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';
import { AuthService } from '../../auth/auth.service';
import { PostCreateModel } from '../models/post-create.model';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-post-create',
  templateUrl: './post-create.component.html',
  styleUrls: ['./post-create.component.css']
})
export class PostCreateComponent implements OnInit {
  bindingModel: PostCreateModel;
  categories: string[] = ['NBA', 'Football', 'NFL', 'MLB', 'F1', 'Volleyball', 'UFC', 'Tennis', 'Football', 'Snooker', 'Athletics'];

  constructor(
    private postService: PostService,
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService) {
    this.bindingModel = new PostCreateModel('', '', '', '', 0, '','')
  }

  ngOnInit() {
  }

  createPost() {
    this.bindingModel.postAuthor = this.authService.getUserName();
    this.bindingModel.postAuthorUid=this.authService.getUserId();
    this.bindingModel.postDate = Date.now();
    this.postService.createPost(this.bindingModel).subscribe((data => {
      this.toastr.success('Post Created!');
      this.router.navigate(['/']);
    }),(err)=>{
      console.log(err)
    })
  }

}

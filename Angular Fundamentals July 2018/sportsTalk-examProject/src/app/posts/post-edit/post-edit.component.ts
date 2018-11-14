import { Component, OnInit } from '@angular/core';
import { PostCreateModel } from '../models/post-create.model';
import { Router, ActivatedRoute } from '@angular/router';
import { PostService } from '../post.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-post-edit',
  templateUrl: './post-edit.component.html',
  styleUrls: ['./post-edit.component.css']
})
export class PostEditComponent implements OnInit {
  bindingModel: PostCreateModel;
  categories: string[] = ['NBA', 'Football', 'NFL', 'MLB', 'F1', 'Volleyball', 'UFC', 'Tennis', 'Football', 'Snooker', 'Athletics'];
  id: string;
  constructor(private router: Router,
    private route: ActivatedRoute,
    private postService: PostService,
  private toastr:ToastrService) { }

  ngOnInit() {
    this.id=this.route.snapshot.params['id'];
    this.postService.getPostById(this.id)
    .subscribe(data=>{
      this.bindingModel=data;
    },(err)=>{
      console.log(err);
    })
  }

  editPost(){
    const body = {
      [this.id]:this.bindingModel
    };
    this.postService.editPost(body)
    .subscribe(data=>{
      this.toastr.success('Post Edited!');
      this.router.navigate(['/post/all']);
    })
  }

}

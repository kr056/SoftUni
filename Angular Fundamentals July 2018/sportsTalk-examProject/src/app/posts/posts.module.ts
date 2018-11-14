import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostAllComponent } from './post-all/post-all.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { PostEditComponent } from './post-edit/post-edit.component';
import { PostByCategoryComponent } from './post-by-category/post-by-category.component';
import { PostCreateComponent } from './post-create/post-create.component';
import { PostsRoutingModule } from './posts.routing';
import { FormsModule } from '@angular/forms';
import { PostUserComponent } from './post-user/post-user.component';
import { PostCommentsComponent } from './post-comments/post-comments.component';


@NgModule({
  imports: [
    CommonModule,
    PostsRoutingModule,
    FormsModule
  ],
  exports:[],
  declarations: [PostAllComponent, PostDetailsComponent, PostEditComponent, PostByCategoryComponent, PostCreateComponent, PostUserComponent, PostCommentsComponent]
})
export class PostsModule { }

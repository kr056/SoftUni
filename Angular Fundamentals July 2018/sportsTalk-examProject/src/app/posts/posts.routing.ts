import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostAllComponent } from './post-all/post-all.component';
import { PostCreateComponent } from './post-create/post-create.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { PostEditComponent } from './post-edit/post-edit.component';
import { PostByCategoryComponent } from './post-by-category/post-by-category.component';
import { AuthGuard } from '../auth/auth.guard';
import { PostUserComponent } from './post-user/post-user.component';

const routes: Routes = [
    { path: 'all', component: PostAllComponent },
    { path: 'category/:name', component: PostByCategoryComponent },
    { path: 'create', component: PostCreateComponent,canActivate:[AuthGuard] },
    { path: 'details/:id', component: PostDetailsComponent },
    { path: 'profile/:id', component: PostUserComponent,canActivate:[AuthGuard] },
    { path: 'edit/:id', component: PostEditComponent,canActivate:[AuthGuard] }
  ]
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class PostsRoutingModule { }
  
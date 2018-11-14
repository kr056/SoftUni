import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from './auth/sign-in/sign-in.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { AboutComponent } from './about/about.component';
import { PostsModule } from './posts/posts.module';

const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: '/post/all', },
    { path: 'about', component: AboutComponent },
    {
        path: 'auth', children: [
            { path: 'signin', component: SignInComponent },
            { path: 'signup', component: SignUpComponent }
        ]
    },
    { path: 'post', loadChildren: () => PostsModule },
    { path: '**', redirectTo: '/post/all' },


];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }

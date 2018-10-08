import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './authentication/register/register.component';
import { LoginComponent } from './authentication/login/login.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
    { path: '',pathMatch:'full',redirectTo:'/'},
    { path: 'home', component: HomeComponent,canActivate:[AuthGuard] },
    { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRouterModule { }
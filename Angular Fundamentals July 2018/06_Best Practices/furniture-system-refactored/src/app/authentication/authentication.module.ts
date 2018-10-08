import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { authComponents } from '.';
import { AuthService } from './auth.service';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  // exports:[
  //   AuthService
  // ],
  declarations: [
    ...authComponents
  ],
  providers:[
    AuthService
  ]
})
export class AuthenticationModule { }

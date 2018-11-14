import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  register(form: NgForm) {
    const firstName = form.value.firstName;
    const lastName = form.value.lastName;
    const username = firstName + ' ' + lastName;
    const email = form.value.email;
    const password = form.value.password;
    this.authService.signUp(email, password, username);
  }

}

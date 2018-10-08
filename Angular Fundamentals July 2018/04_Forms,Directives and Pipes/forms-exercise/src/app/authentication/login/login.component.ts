import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { LoginModel } from '../../models/login.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  model: LoginModel;
  loginFailed: boolean;
  errMessage: string;

  constructor(private authService: AuthService,
    private router: Router) {
    this.model = new LoginModel('', '');
  }

  ngOnInit() {
  }

  login() {
    this.authService.login(this.model)
      .subscribe(
        data => {
          this.authService.authtoken=data['_kmd']['authtoken'];
          localStorage.setItem('authtoken',data['_kmd']['authtoken']);
          localStorage.setItem('username',data['username']);
          this.router.navigate(['/home']);
        },
        err => {
          this.loginFailed = true;
          this.errMessage = err.error.description;
        });
  }
}

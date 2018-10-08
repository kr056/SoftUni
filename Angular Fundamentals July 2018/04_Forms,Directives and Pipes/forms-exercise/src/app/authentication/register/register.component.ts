import { Component, OnInit } from '@angular/core';
import { RegisterModel } from '../../models/register.model';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  model: RegisterModel;
  regFailed: boolean;
  errMessage: string;

  constructor(private authService: AuthService,
    private router: Router) {
    this.model = new RegisterModel('', '', '', '', '', 18);
  }

  ngOnInit() { }

  register() {
    delete this.model['confirmPassword']
    this.authService.register(this.model)
      .subscribe(
        data => {
          this.router.navigate(['/home']);
        },
        err => {
          this.regFailed = true;
          this.errMessage = err.error.description;
        });
  }
}

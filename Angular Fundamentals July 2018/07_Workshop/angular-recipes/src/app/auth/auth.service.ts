import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import * as firebase from 'firebase';
import { Router } from '@angular/router';

@Injectable()
export class AuthService {
  token: string;

  constructor(private toastr: ToastrService,
    private router: Router) { }

  signUp(email: string, password: string) {
    firebase.auth().createUserWithEmailAndPassword(email, password)
      .then((data) => {
        this.router.navigate(['/auth/signin']);
        this.toastr.success('Signed Up');
      }).catch(err => {
        this.toastr.error(err.message);
      });
  }

  signIn(email: string, password: string) {
    firebase.auth().signInWithEmailAndPassword(email, password)
      .then((data) => {
        firebase.auth().currentUser.getIdToken()
          .then((token: string) => {
            this.token = token;
          })

          this.router.navigate(['/recipe/all']);
          this.toastr.success('Signed In');
      }).catch(err => {
        this.toastr.error(err.message);
      });
  }

  logout() {
    firebase.auth().signOut().then(()=>{
      this.token = null;
      this.toastr.success('Logged Out');
      this.router.navigate(['/auth/signin']);
    }).catch(err => {
      this.toastr.error(err.message);
    });
    
  }

  getToken() {
    firebase.auth().currentUser.getIdToken()
      .then((token: string) => {
        this.token = token;
      }).catch(err => {
        // this.toastr.error(err.message);
      });
      
      return this.token;
  }

  isAuthenticated() {
    return this.token != null;
  }
}

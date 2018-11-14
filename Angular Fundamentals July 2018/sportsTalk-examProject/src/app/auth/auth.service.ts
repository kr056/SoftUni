import { Injectable } from '@angular/core';
import * as firebase from 'firebase';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  token: string;

  constructor(private toastr: ToastrService,
    private router: Router,
    private http: HttpClient, ) { }

  signUp(email: string, password: string, username: string) {
    firebase.auth().createUserWithEmailAndPassword(email, password)
      .then(() => {
        let user = firebase.auth().currentUser;

        //update user profile
        user.updateProfile({
          displayName: username,
          photoURL: ''
        }).then(() => {
          this.toastr.success('Signed Up');
          this.router.navigate(['/auth/signin']);
        }).catch((err) => {
          console.log(err)
        })

      }).catch((err) => {
        this.toastr.error(err.message);
      });
  }


  signIn(email: string, password: string) {
    firebase.auth().signInWithEmailAndPassword(email, password)
      .then((data) => {
        firebase.auth().currentUser.getIdToken()
          .then((token: string) => {
            this.token = token;
          }).catch((err) => {
            console.log(err);
          })

        this.toastr.success('Signed In');
        this.router.navigate(['/']);

      }).catch((err) => {
        this.toastr.error(err.message);
      });
  }

  logout() {
    firebase.auth().signOut().then(() => {
      this.token = null;
      this.toastr.success('Logged Out');
      this.router.navigate(['/']);

    }).catch((err) => {
      this.toastr.error(err.message);
    })
  }

  // get user token for db purposes

  getToken() {
    firebase.auth().currentUser.getIdToken()
      .then((token: string) => {
        this.token = token;
      }).catch(err => {
        console.log(err);
      });
    return this.token;
  }

  //get user uid for db purposes
  getUserId() {
    let user = firebase.auth().currentUser;

    if (user !== null) {
      let uid = user.uid;
      return uid;
    }
    
    return null;
  }

  // to get blog post creator name
  getUserName() {
    let user = firebase.auth().currentUser;

    if (user !== null) {
      return user.displayName;
    } else {
      console.log('nono');
    }
  }

  //check if user is authenticated
  isAuthenticated() {
    return this.token != null;
  }
}

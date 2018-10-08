import { Component, OnInit } from '@angular/core';
import * as firebase from 'firebase';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';

  ngOnInit(): void {
    firebase.initializeApp({
      apiKey: "AIzaSyA0oLd-ww2huqPvw3c69uxaRiURNWhnR4o",
      authDomain: "angular-recipes-25c78.firebaseapp.com",
    })
  }
}

import { Component, OnInit } from '@angular/core';
import * as firebase from 'firebase';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'app';

  ngOnInit(): void {
    firebase.initializeApp({
      apiKey:"AIzaSyBiGwVL8PDbeMa5rfFfPXeWei3spG2twEs",
      authDomain:"angular-sportstalk-cb363.firebaseapp.com",
      databaseURL: "https://angular-sportstalk-cb363.firebaseio.com",
    })
  }
}

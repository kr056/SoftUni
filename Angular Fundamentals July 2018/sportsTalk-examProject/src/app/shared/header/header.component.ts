import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  dropdownLi: string = "nav-item dropdown";
  dropdownMenu: string = "dropdown-menu";
  categories: string[] = ['Football', 'NBA', 'Tennis', 'NFL', 'MLB'];
  moreCategories: string[] = ['Snooker', 'Athletics', 'UFC', 'F1', 'Volleyball'];
  constructor(private authService: AuthService) {
  }

  ngOnInit() {
  }

  // create dropdown in header
  expand() {
    this.dropdownLi.endsWith('show')
      ? this.dropdownLi = "nav-item dropdown"
      : this.dropdownLi = "nav-item dropdown show";

    this.dropdownMenu.endsWith('show')
      ? this.dropdownMenu = "dropdown-menu"
      : this.dropdownMenu = "dropdown-menu show";
  }

  //logs out the user

  logout() {
    this.authService.logout();
  }

}

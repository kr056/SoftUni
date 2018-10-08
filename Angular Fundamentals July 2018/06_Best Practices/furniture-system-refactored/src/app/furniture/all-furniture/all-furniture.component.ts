import { Component, OnInit } from '@angular/core';
import { FurnitureModel } from '../models/furniture.model';
import { FurnitureService } from '../furniture.service';
import { Observable } from 'rxjs';
import { AuthService } from '../../authentication/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-furniture',
  templateUrl: './all-furniture.component.html',
  styleUrls: ['./all-furniture.component.css']
})
export class AllFurnitureComponent implements OnInit {
  furnitureArr: Observable<FurnitureModel[]>;
  pageSize: number = 3;
  currentPage: number = 1;

  constructor(
    private furnitureService: FurnitureService,
    private authService: AuthService,
  private router:Router) { }

  ngOnInit() {
    this.furnitureArr = this.furnitureService.getAll();
  }

  changePage(page) {
    this.currentPage = page;
  }

  deleteItem(id){
    this.furnitureService.deleteFurniture(id).subscribe(()=>{
      this.furnitureArr = this.furnitureService.getAll();
    });
  }

}

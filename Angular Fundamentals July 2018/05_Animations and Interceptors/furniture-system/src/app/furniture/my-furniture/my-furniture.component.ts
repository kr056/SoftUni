import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { FurnitureModel } from '../models/furniture.model';
import { FurnitureService } from '../furniture.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-furniture',
  templateUrl: './my-furniture.component.html',
  styleUrls: ['./my-furniture.component.css']
})
export class MyFurnitureComponent implements OnInit {
  myFurnitureArr: Observable<FurnitureModel[]>;

  constructor(private furniteService: FurnitureService,private router:Router) { }

  ngOnInit() {
    this.myFurnitureArr = this.furniteService.myFurniture();
  }

  deleteItem(id: string) {
    this.furniteService.deleteFurniture(id)
    .subscribe(()=>{
      this.router.navigate(['/furniture/all']);
    });
  }

}

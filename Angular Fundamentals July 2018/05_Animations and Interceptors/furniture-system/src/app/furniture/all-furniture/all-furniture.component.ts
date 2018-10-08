import { Component, OnInit } from '@angular/core';
import { FurnitureModel } from '../models/furniture.model';
import { FurnitureService } from '../furniture.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-all-furniture',
  templateUrl: './all-furniture.component.html',
  styleUrls: ['./all-furniture.component.css']
})
export class AllFurnitureComponent implements OnInit {
  furnitureArr: Observable<FurnitureModel[]>
  constructor(
    private furnitureService: FurnitureService) { }

  ngOnInit() {
    this.furnitureArr = this.furnitureService.getAll();
  }

}

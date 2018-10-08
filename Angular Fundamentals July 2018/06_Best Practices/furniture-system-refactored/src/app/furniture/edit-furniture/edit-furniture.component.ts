import { Component, OnInit } from '@angular/core';
import { FurnitureModel } from '../models/furniture.model';
import { FurnitureService } from '../furniture.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-edit-furniture',
  templateUrl: './edit-furniture.component.html',
  styleUrls: ['./edit-furniture.component.css']
})
export class EditFurnitureComponent implements OnInit {
  bindingModel: FurnitureModel;

  constructor(private route: ActivatedRoute,
    private furnitureService: FurnitureService,
    private router: Router) { }

  ngOnInit() {
    this.furnitureService.getFurnitureById(
      this.route.snapshot.params['id']).subscribe(data => {
        this.bindingModel = data;
      })
  }

  edit() {
    this.furnitureService.editFurniture(this.bindingModel.id, this.bindingModel)
      .subscribe(() => {
        this.router.navigate(['/furniture/all']);
      });
  }

}

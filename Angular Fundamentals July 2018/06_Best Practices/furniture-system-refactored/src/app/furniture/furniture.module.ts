import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { furnitureComponents } from '.';
import { FormsModule } from '@angular/forms';
import { FurnitureService } from './furniture.service';
import { RouterModule } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
import { FurnitureRoutingModule } from './furniture-routing';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    FurnitureRoutingModule,
    NgxPaginationModule
  ],
  declarations: [
    ...furnitureComponents,
  ],
  providers:[
    FurnitureService
  ]
})
export class FurnitureModule { }

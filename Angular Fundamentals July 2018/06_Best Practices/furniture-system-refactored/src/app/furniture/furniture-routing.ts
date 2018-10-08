import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateFurnitureComponent } from './create-furniture/create-furniture.component';
import { AllFurnitureComponent } from './all-furniture/all-furniture.component';
import { FurnitureDetailsComponent } from './furniture-details/furniture-details.component';
import { MyFurnitureComponent } from './my-furniture/my-furniture.component';
import { EditFurnitureComponent } from './edit-furniture/edit-furniture.component';

const routes: Routes = [
    { path: 'create', component: CreateFurnitureComponent },
    { path: 'all', component: AllFurnitureComponent },
    { path: 'details/:id', component: FurnitureDetailsComponent },
    { path: 'edit/:id', component: EditFurnitureComponent },
    { path: 'mine', component: MyFurnitureComponent },
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class FurnitureRoutingModule { }
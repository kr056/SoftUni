import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RecipeAllComponent } from './recipe-all/recipe-all.component';
import { RecipeCreateComponent } from './recipe-create/recipe-create.component';
import { RecipeEditComponent } from './recipe-edit/recipe-edit.component';
import { RecipeDetailsComponent } from './recipe-details/recipe-details.component';
import { RecipeService } from './recipe.service';
import { RecipeRoutingModule } from './recipe-routing/recipe-routing.module';
import { FormsModule } from '@angular/forms';



@NgModule({
  imports: [
    CommonModule,
    RecipeRoutingModule,
    FormsModule
  ],
  declarations: [RecipeAllComponent, RecipeCreateComponent, RecipeEditComponent, RecipeDetailsComponent],
  providers:[
    RecipeService
  ]
})
export class RecipeModule { }

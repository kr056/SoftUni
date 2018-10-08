import { Component, OnInit } from '@angular/core';
import { RecipeCreate } from '../models/recipe-create.model';
import { RecipeService } from '../recipe.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recipe-create',
  templateUrl: './recipe-create.component.html',
  styleUrls: ['./recipe-create.component.css']
})
export class RecipeCreateComponent implements OnInit {
  bindingModel:RecipeCreate;

  constructor(private recipeService:RecipeService,
  private router:Router) { 
    this.bindingModel=new RecipeCreate('','','');
  }

  ngOnInit() {
  }

  createRecipe(){
    this.recipeService.createRecipe(this.bindingModel)
    .subscribe((data)=>{
      this.router.navigate(['/recipe/all']);
    });
  }

}

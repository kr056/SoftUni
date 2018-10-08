import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { RecipeList } from '../models/recipe-list.model';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-recipe-all',
  templateUrl: './recipe-all.component.html',
  styleUrls: ['./recipe-all.component.css']
})
export class RecipeAllComponent implements OnInit {

  recipes: Observable<RecipeList[]>;

  constructor(private recipeService:RecipeService) { }

  ngOnInit() {
    this.recipes=this.recipeService.getAllRecipes();
  }

}

import { Component, OnInit } from '@angular/core';
import { RecipeList } from '../models/recipe-list.model';
import { RecipeService } from '../recipe.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css']
})
export class RecipeDetailsComponent implements OnInit {
  recipe: RecipeList;
  id: string;

  constructor(private recipeService: RecipeService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    
    this.recipeService.getById(this.id)
      .subscribe(data => {
        this.recipe = data;
      })
  }

  delete() {
    this.recipeService.deleteRecipe(this.id)
      .subscribe(data => {
        this.router.navigate(['/recipe/all']);
      })
  }

}

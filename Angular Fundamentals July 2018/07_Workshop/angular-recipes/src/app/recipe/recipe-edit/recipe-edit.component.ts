import { Component, OnInit } from '@angular/core';
import { RecipeCreate } from '../models/recipe-create.model';
import { Router, ActivatedRoute } from '@angular/router';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-recipe-edit',
  templateUrl: './recipe-edit.component.html',
  styleUrls: ['./recipe-edit.component.css']
})
export class RecipeEditComponent implements OnInit {
  bindingModel: RecipeCreate;
  id: string;

  constructor(private recipeService: RecipeService,
    private router: Router,
    private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.id=this.route.snapshot.params['id'];

    this.recipeService.getById(this.id)
    .subscribe(data=>{
      this.bindingModel=data;
    })
  }

  editRecipe(){
    const body = {
      [this.id]:this.bindingModel
    };

    this.recipeService.editRecipe(body)
    .subscribe(data=>{
      this.router.navigate(['/recipe/all']);
    })
  }

}

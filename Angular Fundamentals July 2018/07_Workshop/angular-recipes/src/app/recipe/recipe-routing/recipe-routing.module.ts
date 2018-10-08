import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RecipeAllComponent } from '../recipe-all/recipe-all.component';
import { AuthGuard } from '../../auth/auth.guard';
import { RecipeCreateComponent } from '../recipe-create/recipe-create.component';
import { RecipeEditComponent } from '../recipe-edit/recipe-edit.component';
import { RecipeDetailsComponent } from '../recipe-details/recipe-details.component';

const routes: Routes = [
  { path: 'all', component: RecipeAllComponent,canActivate:[AuthGuard] },
  { path: 'create', component: RecipeCreateComponent,canActivate:[AuthGuard] },
  { path: 'details/:id', component: RecipeDetailsComponent,canActivate:[AuthGuard] },
  { path: 'edit/:id', component: RecipeEditComponent,canActivate:[AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RecipeRoutingModule { }

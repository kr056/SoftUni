import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { sharedComponents } from '.';
import { RouterModule } from '@angular/router';
import { NavigationComponent } from './navigation/navigation.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  exports:[
    NavigationComponent
  ],
  declarations: [
    ...sharedComponents
  ]
})
export class SharedModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import { ResetPasswordComponent } from './auth/reset-password/reset-password.component';
import { AddCategoryModalComponent } from './home/add-category-modal/add-category-modal.component';
import { HomePageComponent } from './home/home-page/home-page.component';

const routes: Routes = [
  {
    path:"register",
    component:RegisterComponent
  },
  {
    path:"login",
    component:LoginComponent
  },{
    path:"reset-password/:token",
    component:ResetPasswordComponent
  },
  {
    path:"add-category",
    component:AddCategoryModalComponent
  },
  {
    path:"home",
    component:HomePageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

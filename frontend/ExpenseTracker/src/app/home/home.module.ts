import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddCategoryModalComponent } from './add-category-modal/add-category-modal.component';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { HomePageComponent } from './home-page/home-page.component';
import { SharedModule } from '../shared/shared.module';
import { MatSelectModule } from '@angular/material/select';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';



@NgModule({
  declarations: [
  
    AddCategoryModalComponent,
    HomePageComponent
  ],
  imports: [
    CommonModule,
   ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,  
    ToastrModule,
    MatDialogModule,
    FormsModule,
    MatFormFieldModule,  
    MatInputModule,      
    MatButtonModule,
    SharedModule,
    MatSelectModule
    
  
  ]
})
export class HomeModule { }

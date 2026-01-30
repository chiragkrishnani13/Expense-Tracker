import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddCategoryModalComponent } from 'src/app/home/add-category-modal/add-category-modal.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(private dialog:MatDialog){}
  openAddCategoryModal(){
    this.dialog.open(AddCategoryModalComponent,{
      width:"420px"
    })
    console.log("object")

  }

}

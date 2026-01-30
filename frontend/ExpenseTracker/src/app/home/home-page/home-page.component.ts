import { Component } from '@angular/core';
import { CategoryService } from '../services/category.service';
import { MatDialog } from '@angular/material/dialog';
import { AddCategoryModalComponent } from '../add-category-modal/add-category-modal.component';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

  categorys:any = []  
  constructor(private categoryService:CategoryService,private dialog:MatDialog){}

  ngOnInit(){
    this.categoryService.getCategoryByUserId(10).subscribe((data)=>{
      this.categorys = data
      console.log(this.categorys)
    })
  }
  editCategory(category: any) {
  console.log('Edit category:', category);

  this.dialog.open(AddCategoryModalComponent, {
    
    data: category,
    width: '420px'
  });
  this.dialog.afterAllClosed.subscribe(res=>{
    this.reloadData()
    console.log(res)
  })
  console.log(category)
}

deleteCategory(id: number) {
  if (!confirm('Are you sure you want to delete this category?')) return;

  console.log('Delete category ID:', id);

  // Example API call
  // this.categoryService.deleteCategory(id).subscribe(() => {
  //   this.categories = this.categories.filter(c => c.category_id !== id);
  // });
}
reloadData(){
  this.ngOnInit()
}



}

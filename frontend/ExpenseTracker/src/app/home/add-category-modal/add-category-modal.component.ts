import { Component, Inject } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-add-category-modal',
  templateUrl: './add-category-modal.component.html',
  styleUrls: ['./add-category-modal.component.css']
})
export class AddCategoryModalComponent {
    category: any = {};

  constructor(private modal:MatDialogRef<AddCategoryModalComponent>,private categoryService:CategoryService,@Inject(MAT_DIALOG_DATA) public data: any){
    this.category = { ...data };
    console.log(this.category)
  }
  
fileName = '';
previewUrl: string | null = null;

onFileSelected(event: any) {
  const file = event.target.files[0];
  if (!file) return;

  this.fileName = file.name;

  const reader = new FileReader();
  reader.onload = () => this.previewUrl = reader.result as string;
  reader.readAsDataURL(file);
}
submit(form: NgForm) {
    if (form.invalid) return;

    const category = {
      user_id:10,
      category_name: form.value.category_name,
      description: form.value.description,
      icon_url: this.fileName,
      transcation_type: form.value.transcation_type
    };
    if(this.category.category_id){
      if(this.fileName){
        this.category.icon_url = this.fileName
      }
      console.log(this.category.icon_url)
      this.categoryService.editCategory(this.category).subscribe({
        next:(res)=>{
          console.log(this.category)
        }
      })

    }
    else{

      this.categoryService.saveCategory(category).subscribe({
      next:(res)=>{
        console.log(res)
      }
    })
    this.modal.close(true)
    }
    

    console.log(category);
    this.modal.close(category);
  }

}

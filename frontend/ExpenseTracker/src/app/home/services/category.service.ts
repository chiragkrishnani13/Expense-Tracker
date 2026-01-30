import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient:HttpClient) { }
  private backend_url = "http://localhost:8080"
  saveCategory(data:any){
    return this.httpClient.post(`${this.backend_url}/category`,data)
  }
  getCategoryByUserId(id:number){
    return this.httpClient.get(`${this.backend_url}/category/${id}`)
  }
  editCategory(data:any){
    return this.httpClient.put(`${this.backend_url}/category`,data)

  }

}

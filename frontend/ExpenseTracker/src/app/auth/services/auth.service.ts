import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient:HttpClient) { }
  backed_url="http://localhost:8080"

  createUser(data: any){
    return this.httpClient.post(`${this.backed_url}/register`,data)
  }
  forgotPassword(email: string) {
  return this.httpClient.post(`${this.backed_url}/forget-password`, { "email":email });
}
validToken(token:string){
  return this.httpClient.post(`${this.backed_url}/valid-token`,{token})
}
updatePassword(data:any){
  return this.httpClient.post(`${this.backed_url}/update-password`,data)
}

}

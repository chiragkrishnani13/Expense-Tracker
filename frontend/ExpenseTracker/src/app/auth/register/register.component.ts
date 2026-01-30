import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  isError:boolean=false
  errMessage:any
  constructor(private router:Router,private authServive:AuthService,private toast:ToastrService){
  }
  user = new FormGroup({
    email: new FormControl('',[Validators.required,Validators.email,Validators.pattern('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$')]),
    username:new FormControl('',[Validators.required]),
    name:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required]),
    phoneNo:new FormControl('',[Validators.required,Validators.pattern('^[0-9]{10}$')])
  })
  onSumbit(){
    console.log(this.user.value)
   
    this.authServive.createUser(this.user.value).subscribe({
      next:(res)=>{
        this.isError = false
         console.log("Success:", res);
         this.router.navigate(["/login"])
      },
      error:(err:HttpErrorResponse)=>{
        const msg = err.error?.body || "Registration failed";
        this.isError= true
        this.errMessage = err.error.body
        this.toast.error(msg);
      }
    })
    
  }
}

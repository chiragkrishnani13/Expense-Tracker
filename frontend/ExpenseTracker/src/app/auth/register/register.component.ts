import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private router:Router){

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
    this.router.navigate(['login'])
  }
}

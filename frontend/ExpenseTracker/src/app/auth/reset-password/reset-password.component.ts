import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent {

  token!: string;

  resetForm = this.fb.group({
    password: ['', [Validators.required, Validators.minLength(6)]],
    confirmPassword: ['', Validators.required]
  }, { validators: this.passwordMatch });

  constructor(
    private activated: ActivatedRoute,
    private fb: FormBuilder,
    private authService: AuthService,
    private toastr: ToastrService,
    private router: Router

  ) {}

  ngOnInit(){
    this.token = this.activated.snapshot.paramMap.get('token') || '';
    console.log(this.token)
    this.authService.validToken(this.token).subscribe({
      error: (err) => {
        this.toastr.error(err.error?.body || "Token Time Expired");
        this.router.navigate(['/login'])
      }
    })
    
  }

  passwordMatch(form: any) {
    const p = form.get('password')?.value;
    const c = form.get('confirmPassword')?.value;
    return p === c ? null : { mismatch: true };
  }

  onSubmit() {
    if(this.resetForm.invalid){
      this.toastr.error("Invalid form");
      return;
    }
    else{
    const data = {
      "password":this.resetForm.value.password,
      "token":this.token
    }
    this.authService.updatePassword(data).subscribe({
      next:()=>{
        this.toastr.success("Password Updated")
      },
      error:(err)=>{
        this.toastr.error("Link Expired")
      }
    })
      
    }

    

    
  }
}

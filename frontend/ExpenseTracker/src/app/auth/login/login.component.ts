import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ForgotPasswordModalComponent } from '../forgot-password-modal/forgot-password-modal.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private dialog: MatDialog) {}
  openForgotPassword() {
  this.dialog.open(ForgotPasswordModalComponent, {
  width: '400px',
  disableClose: true,
  autoFocus: false,
  restoreFocus: false

  });
  }
  isOpen = false
  user = new FormGroup({
    username:new FormControl('',Validators.required),
    password:new FormControl('',Validators.required)
  })

}

import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../services/auth.service';
@Component({
  selector: 'app-forgot-password-modal',
  templateUrl: './forgot-password-modal.component.html',
  styleUrls: ['./forgot-password-modal.component.css']
})
export class ForgotPasswordModalComponent {

  email = '';

  constructor(
    private dialogRef: MatDialogRef<ForgotPasswordModalComponent>,
    private authService: AuthService,
    private toastr: ToastrService
  ) {}

  submit() {
    this.authService.forgotPassword(this.email).subscribe({
      next: () => {
        this.toastr.success("Reset link sent to your email");
        this.dialogRef.close();
      },
      error: (err) => {
        this.toastr.error(err.error?.body || "Email not found");
      }
    });
  }
}

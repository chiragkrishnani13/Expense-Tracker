import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthModule } from './auth/auth.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ForgotPasswordModalComponent } from './auth/forgot-password-modal/forgot-password-modal.component';
import { Overlay, ToastrModule } from 'ngx-toastr';
import { HomeModule } from './home/home.module';
import { SharedModule } from './shared/shared.module';
import { OverlayModule } from '@angular/cdk/overlay';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AuthModule,
    ToastrModule.forRoot({     // ✅ global config
          timeOut: 3000,
          positionClass: 'toast-top-center',
          preventDuplicates: true,
        }),
    HomeModule,
    BrowserAnimationsModule,
    SharedModule,
    OverlayModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

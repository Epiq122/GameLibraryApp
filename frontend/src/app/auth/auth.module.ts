import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { PasswordResetComponent } from './password-reset/password-reset.component';



@NgModule({
  declarations: [
    RegistrationComponent,
    LoginComponent,
    PasswordResetComponent
  ],
  imports: [
    CommonModule
  ]
})
export class AuthModule { }

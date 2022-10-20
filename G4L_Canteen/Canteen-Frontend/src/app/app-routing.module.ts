import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/authenticate/login/login.component';
import { SignUpComponent } from './components/authenticate/sign-up/sign-up.component';
import { ResetPasswordComponent } from './components/authenticate/reset-password/reset-password.component';{}

const routes: Routes = [

  {
    path: "authenticate",
    children: [{ path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'sign-up', component: SignUpComponent },
    { path: 'reset-password1', component: ResetPasswordComponent }
    ]
  },
    ]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

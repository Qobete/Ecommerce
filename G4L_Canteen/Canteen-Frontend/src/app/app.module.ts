import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './Components/customer/customer.component';
import { HomeComponent } from './Components/customer/home/home.component';
import { LoggingService } from './Models/LoggingService';
import { AuthenticateComponent } from './Components/authenticate/authenticate.component';
import { LoginComponent } from './Components/authenticate/login/login.component';
import { SignUpComponent } from './Components/authenticate/sign-up/sign-up.component';
import { ResetPasswordComponent } from './Components/authenticate/reset-password/reset-password.component';
import { ResetNowComponent } from './Components/authenticate/reset-password/reset-now.component';
import { AdminHomeComponent } from './Components/admin-home/admin-home.component';
import { DashboardComponent } from './Components/admin-home/dashboard/dashboard.component';
import { AddCategoryComponent } from './Components/admin-home/add-category/add-category.component';
import { AddSubcategoryComponent } from './Components/admin-home/add-subcategory/add-subcategory.component';
import { AddItemComponent } from './Components/admin-home/add-item/add-item.component';
import { ItemsAdminComponent } from './Components/admin-home/items-admin/items-admin.component';
import { MergeArrayPipe } from './Pipes/AdminPipes/merge-array.pipe';
import { SearchItemsPipe } from './Pipes/AdminPipes/search-items.pipe';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CustomerComponent,
    AuthenticateComponent,
    LoginComponent,
    SignUpComponent,
    ResetPasswordComponent,
    ResetNowComponent,
    AdminHomeComponent,
    DashboardComponent,
    AddCategoryComponent,
    AddSubcategoryComponent,
    AddItemComponent,
    ItemsAdminComponent,
    MergeArrayPipe,
    SearchItemsPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [LoggingService],
  bootstrap: [AppComponent]
})
export class AppModule { }

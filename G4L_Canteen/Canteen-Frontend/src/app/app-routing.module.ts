import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerComponent } from './Components/customer/customer.component';
import { HomeComponent } from './Components/customer/home/home.component';
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


const routes: Routes = [
  { path: "", component: CustomerComponent },
  {
    path: "customer", component: CustomerComponent, children: [{ path: "", component: HomeComponent },
  
    ]
  },

  {
    path: "authenticate", component: AuthenticateComponent,
    children: [{ path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'sign-up', component: SignUpComponent },
    { path: 'reset-password', component: ResetNowComponent },
    { path: 'reset-password1', component: ResetPasswordComponent }
    ]
  },

  {
    path: 'admin', component: AdminHomeComponent,
    children: [{ path: 'dashboard', component: DashboardComponent },
    { path: '', component: DashboardComponent },
    // { path: 'orders', component: OrdersComponent },
    { path: 'addItem', component: AddItemComponent },
    { path: 'addCategory', component: AddCategoryComponent },
    { path: 'addSubCategory', component: AddSubcategoryComponent },
    // { path: 'orders', component: OrdersComponent },
     { path: 'items', component: ItemsAdminComponent },
    // { path: 'categories', component: CategoriesComponent },
    // { path: 'subCategories', component: SubcategoriesComponent },
     { path: 'addItem/:itemId', component: AddItemComponent }
    // { path: 'r&p', component: RolesPermissionsComponent }
    ]
  },
]

@NgModule({
  imports: 
   [RouterModule.forRoot(routes)],

  exports: [RouterModule]
})
export class AppRoutingModule { }

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
import { SubcategoriesComponent } from './Components/admin-home/subcategories/subcategories.component';
import { CategoriesComponent } from './Components/admin-home/categories/categories.component';
import { RolesPermissionsComponent } from './Components/admin-home/roles-permissions/roles-permissions.component';
import { OrdersComponent } from './Components/admin-home/orders/orders.component';
import { ItemsComponent } from './Components/customer/items/items.component';
import { CarryBoxComponent } from './Components/customer/carry-box/carry-box.component';
import { PlaceOrderComponent } from './Components/customer/place-order/place-order.component';
import { MyOrdersComponent } from './Components/customer/my-orders/my-orders.component';
import { MyAccountComponent } from './Components/customer/my-account/my-account.component';
import { TrackOrderComponent } from './Components/customer/track-order/track-order.component';

const routes: Routes = [
  { path: "", component: CustomerComponent },
  {
    path: "customer", component: CustomerComponent, 
    children: [{ path: "", component: HomeComponent },
    { path: "items/:type/:filter", component: ItemsComponent },
    { path: "myCarryBox", component: CarryBoxComponent },
    { path: "placeOrder", component: PlaceOrderComponent },
    { path: "myOrders", component: MyOrdersComponent },
    { path: "myAccount", component: MyAccountComponent },
    { path: "trackOrder/:orderId", component: TrackOrderComponent }
  
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
    { path: 'addItem', component: AddItemComponent },
    { path: 'addCategory', component: AddCategoryComponent },
    { path: 'addSubCategory', component: AddSubcategoryComponent },
    { path: 'orders', component: OrdersComponent },
    { path: 'items', component: ItemsAdminComponent },
    { path: 'categories', component: CategoriesComponent },
    { path: 'subCategories', component: SubcategoriesComponent },
    { path: 'addItem/:itemId', component: AddItemComponent },
    { path: 'r&p', component: RolesPermissionsComponent }
    ]
  },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

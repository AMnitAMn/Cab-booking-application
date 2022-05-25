import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ViewAllAdminsComponent } from './admin-dashboard/view-all-admins/view-all-admins.component';
import { ViewAllCustomersComponent } from './admin-dashboard/view-all-customers/view-all-customers.component';
import { ViewAllDriversComponent } from './admin-dashboard/view-all-drivers/view-all-drivers.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { BookCabComponent } from './customer-dashboard/book-cab/book-cab.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { UpdateCustomerComponent } from './customer-dashboard/update-customer/update-customer.component'

const routes: Routes = [
  
  {path:'register',component:SignupComponent},
  {path:'userLogin',component:LoginComponent},
  {path:'customerDashboard',component:CustomerDashboardComponent},
  {path:'adminLogin',component:AdminLoginComponent},
  {path:'adminDashboard',component:AdminDashboardComponent},
  {path:'allAdmins',component:ViewAllAdminsComponent},
  {path:'allCustomers',component:ViewAllCustomersComponent},
  {path:'allDrivers',component:ViewAllDriversComponent},

  {path:'bookCab', component:BookCabComponent},
  {path:'updateCustomer', component:UpdateCustomerComponent},

  {path:'**',component:HomepageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

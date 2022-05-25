import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ViewAllAdminsComponent } from './admin-dashboard/view-all-admins/view-all-admins.component';
import { ViewAllCustomersComponent } from './admin-dashboard/view-all-customers/view-all-customers.component';
import { ViewAllDriversComponent } from './admin-dashboard/view-all-drivers/view-all-drivers.component';
import { BookCabComponent } from './customer-dashboard/book-cab/book-cab.component';
import { CabComponent } from './cab/cab.component';
import { TripBookingComponent } from './trip-booking/trip-booking.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    HomepageComponent,
    CustomerDashboardComponent,
    AdminDashboardComponent,
    AdminLoginComponent,
    ViewAllAdminsComponent,
    ViewAllCustomersComponent,
    ViewAllDriversComponent,
    BookCabComponent,
    CabComponent,
    TripBookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

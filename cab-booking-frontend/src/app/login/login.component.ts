import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { customer } from 'src/app/utils/customer';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  customer:customer=new customer();
  constructor(private router:Router,private loginService:LoginService) { }

  ngOnInit(): void {
  }

  userLogin(){
    this.loginService.checkCustomer(this.customer)
      .subscribe( data => {
        if(data == ''){
          alert("Username or Password is incorrect");

          return;
        
        }else{
          alert("Login Successful");}

          this.router.navigate(['/customerDashboard'], { queryParams: {custId: JSON.parse(data).customerId } });
        }
      );
}
}

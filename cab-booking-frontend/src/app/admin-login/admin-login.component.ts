import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { admin } from '../models/admin';
import { AdminLoginService } from './admin-login.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  admin:admin=new admin();
  constructor(private router:Router,private adminService:AdminLoginService) { }

  ngOnInit(): void {
  }

  adminLogin(){
    this.adminService.checkAdmin(this.admin)
      .subscribe( data => {
        if(data == ""){
          alert("Username or Password is incorrect");

          return;
        
        }else{
            
        
          alert("Login Successful");}

          this.router.navigate(['/adminDashboard']);
        }
      );
}
}

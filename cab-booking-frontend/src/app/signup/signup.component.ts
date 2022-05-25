import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { customer } from '../models/customer';
import { SignupService } from './signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private router:Router, private signupService:SignupService) { }
  customer:customer = new customer();
  ngOnInit(): void {
  }

  addCustomer(): void {
    this.signupService.addCustomer(this.customer)
      .subscribe( data => {
        alert("Sign Up Successful");
      });
      this.router.navigate([''])

};

}

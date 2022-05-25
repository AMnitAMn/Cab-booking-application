import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { customer } from 'src/app/utils/customer';
import { CustomerService } from 'src/app/customer/customer.service';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']
})
export class CustomerDashboardComponent implements OnInit {


  custId:number = 0;
  customer!:customer;
  constructor(private route: ActivatedRoute, private customerService:CustomerService, private router:Router) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
     this.custId = params['custId'];
      this.customerService.getCustomerDetailsById(this.custId).subscribe((data) =>
      this.customer = (data as customer)
      );
     });
  }
 
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient:HttpClient) { }
  private admin_base_url = 'http://localhost:8080/admin/';
  private customer_base_url = 'http://localhost:8080/customer/';
  private driver_base_url = 'http://localhost:8080/driver/';

  getAllAdminDetails(){
    return this.httpClient.get(this.admin_base_url);
  }

  getAllCustomerDetails(){
    return this.httpClient.get(this.customer_base_url+'all');
  }

  getAllDriverDetails(){
    return this.httpClient.get(this.driver_base_url);
  }

  deleteAdmin(id:number){
    return this.httpClient.delete(this.admin_base_url+'delete/'+id).subscribe(data=>{
      console.log(data);
    });
  }

  deleteCustomer(customerId:number){
    return this.httpClient.delete(this.customer_base_url+'delete/'+customerId).subscribe(data=>{
      console.log(data);
    });
  }
}

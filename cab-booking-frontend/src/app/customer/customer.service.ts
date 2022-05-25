import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  httpOptions = {
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  } 
  constructor(private httpClient:HttpClient) {}

  private customer_base_url = 'http://localhost:8080/customer/';


  getCustomerDetailsById(id:number){
    return this.httpClient.get(this.customer_base_url+id);
  }

  getAllCustomerDetails(){
    return this.httpClient.get(this.customer_base_url+'all');
  }


  addAdmin(cust:customer):Observable<customer>{
    return this.httpClient.post<customer>(this.customer_base_url,cust,this.httpOptions);
  }

}

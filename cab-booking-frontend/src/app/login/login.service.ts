import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { customer } from '../models/customer';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'text/plain' })
}; 

@Injectable({
  providedIn: 'root'
})

export class LoginService {
  private customer_url = 'http://localhost:8080/customer/login/';

  constructor(private httpClient:HttpClient) { }

  checkCustomer(customer:customer){
    return this.httpClient.post(this.customer_url,customer,{responseType:'text'});
    }
}

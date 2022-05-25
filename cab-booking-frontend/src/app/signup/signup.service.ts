import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private httpClient:HttpClient) { }
  private customer_url = 'http://localhost:8080/customer';

  addCustomer(customer:customer){
    return this.httpClient.post<customer>(this.customer_url,customer);
  }
}

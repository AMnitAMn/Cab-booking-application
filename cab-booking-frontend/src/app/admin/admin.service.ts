import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { admin } from '../utils/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  httpOptions = {
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  constructor(private httpClient:HttpClient) {}

  private admin_base_url = 'http://localhost:8080/admin/';
  private customer_base_url = 'http://localhost:8080/customer/';
  private driver_base_url = 'http://localhost:8080/driver/';

  getAllAdminDetails(){
    return this.httpClient.get(this.admin_base_url);
  }

  getAdminDetailsById(id:number){
    return this.httpClient.get(this.admin_base_url+id);
  }

  getAllCustomerDetails(){
    return this.httpClient.get(this.customer_base_url+'all');
  }

  getAllDriverDetails(){
    return this.httpClient.get(this.driver_base_url);
  }

  viewProfile(id:number){
    return this.httpClient.get(this.admin_base_url+id);
  }

  addAdmin(admin:admin):Observable<admin>{
    return this.httpClient.post<admin>(this.admin_base_url,admin,this.httpOptions);
  }
  
}

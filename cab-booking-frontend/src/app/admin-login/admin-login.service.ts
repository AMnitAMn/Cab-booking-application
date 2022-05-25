import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { admin } from '../models/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminLoginService {
  private admin_url = 'http://localhost:8080/admin/login/';
  constructor(private httpClient:HttpClient) { }

  checkAdmin(admin:admin){
    return this.httpClient.post(this.admin_url,admin,{responseType:'text'});
    }
}

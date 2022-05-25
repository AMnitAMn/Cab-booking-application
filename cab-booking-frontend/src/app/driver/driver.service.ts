import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { driver } from '../utils/driver';

@Injectable({
  providedIn: 'root'
})
export class DriverService {
  httpOptions = {
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  constructor(private httpClient:HttpClient) {}

  private driver_base_url = 'http://localhost:8080/driver/';

  getAllDrivers(){
    return this.httpClient.get(this.driver_base_url);
  }

  getDriverById(id:number){
    return this.httpClient.get(this.driver_base_url+id);
  }

  getDriverByCarType(type:string){
    return this.httpClient.get(this.driver_base_url+'/carType/'+type);
  }

  getBestDrivers(){
    return this.httpClient.get(this.driver_base_url+'/bestdrivers');
  }

  addDriver(driver:driver):Observable<driver>{
    return this.httpClient.post<driver>(this.driver_base_url,driver,this.httpOptions);
  }

  updateDriver(driver:driver):Observable<driver>{
    return this.httpClient.put<driver>(this.driver_base_url,driver,this.httpOptions);
  }

}
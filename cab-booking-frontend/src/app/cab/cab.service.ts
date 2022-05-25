import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { cab } from '../utils/cab';

@Injectable({
  providedIn: 'root'
})
export class CabService {
  [x: string]: any;
  httpOptions = {
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  constructor(private httpClient:HttpClient) {}

  private cab_base_url = 'http://localhost:8080/cab';

  getAllCabDetails(){
    return this.httpClient.get(this.cab_base_url);
  }

  getCabById(id:number){
    return this.httpClient.get(this.cab_base_url+id);
  }

  getCountCabOfType(type:string){
    return this.httpClient.get(this.cab_base_url+'/count/'+type);
  }

  getCabOfType(type:string){
    return this.httpClient.get(this.cab_base_url+'/type/'+ type);
  }

  addCab(cab:cab):Observable<cab>{
    return this.httpClient.post<cab>(this.cab_base_url,cab,this.httpOptions);
  }

  updateCab(cab:cab):Observable<cab>{
    return this.httpClient.put<cab>(this.cab_base_url,cab,this.httpOptions);
  }
  
}
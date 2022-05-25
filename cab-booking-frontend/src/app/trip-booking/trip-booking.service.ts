import { Injectable } from '@angular/core';
import { trip } from '../models/trip';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TripBookingService {

  constructor(private httpClient:HttpClient) { }

  private trip_url = 'http://localhost:8080/tripbooking';

  addTrip(trip:trip){
    return this.httpClient.post<trip>(this.trip_url,trip);
  }
}

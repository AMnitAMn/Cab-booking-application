import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { trip } from '../models/trip';
import { TripBookingService } from './trip-booking.service';

@Component({
  selector: 'app-trip-booking',
  templateUrl: './trip-booking.component.html',
  styleUrls: ['./trip-booking.component.css']
})
export class TripBookingComponent implements OnInit {

  constructor(private router:Router, private tripBookingService:TripBookingService) { }
  trip:trip = new trip();
  ngOnInit(): void {
  }

  addTrip(): void {
    this.tripBookingService.addTrip(this.trip)
      .subscribe( data => {
        alert("Cab Booked Succesfully");
      });
      this.router.navigate([''])

};

}

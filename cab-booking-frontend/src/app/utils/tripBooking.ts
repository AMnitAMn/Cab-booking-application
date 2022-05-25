import { customer } from "./customer";
import { driver } from "./driver";

export class tripBooking{
    tripBookingId!:number;
    customer!:customer;
    driver!:driver;
    fromLocation:string;
    toLocation:string;
    fromDateTime:Date;
    toDateTime:Date;
    status:boolean;
    distanceInKm:number;
    bill:number;

    constructor(){
        this.fromLocation='';
        this.toLocation='';
        this.fromDateTime=new Date();
        this.toDateTime=new Date();
        this.status=false;
        this.distanceInKm=0.0;
        this.bill=0.0;
    }
}
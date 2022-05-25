import { cab } from "./cab";

export class driver{
    driverId!:number;
    username:string;
    password:string;
    email:string;
    mobileNumber:string;
    licenseNumber:string;
    cab!:cab;
    rating:number;

    constructor(){
        this.username='';
        this.password='';
        this.email='';
        this.mobileNumber='';
        this.licenseNumber='';
        this.rating=0.0
    }
}
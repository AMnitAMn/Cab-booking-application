export class customer{
    customerId!:number;
    username:string;
    password:string;
    email:string;
    mobileNumber:string;

    constructor(){
        this.username='';
        this.password='';
        this.email='';
        this.mobileNumber='';
    }
}
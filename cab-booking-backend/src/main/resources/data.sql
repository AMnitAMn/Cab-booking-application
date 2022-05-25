insert into customer(customer_id, username, email, mobile_number, address, password) 
values(10001, 'Customer 1', 'customer1@gmail.com', '123456789', 'Mumbai', '1234567');

insert into customer(customer_id, username, email, mobile_number, address, password) 
values(10002, 'Customer 2', 'customer2@gmail.com', '234567890', 'Mumbai', '1234567');

insert into customer(customer_id, username, email, mobile_number, address, password) 
values(10003, 'Customer 3', 'customer3@gmail.com', '345678912', 'Mumbai', '1234567');

insert into customer(customer_id, username, email, mobile_number, address, password) 
values(10004, 'Customer 4', 'customer4@gmail.com', '456789123', 'Mumbai', '1234567');

insert into customer(customer_id, username, email, mobile_number, address, password) 
values(10005, 'Customer 5', 'customer5@gmail.com', '567894567', 'Mumbai', '1234567');



insert into admin(admin_id, username, email, mobile_number, address, password) 
values(20001, 'Admin 1', 'admin1@gmail.com', '123456789', 'Mumbai', '1234567');

insert into admin(admin_id, username, email, mobile_number, address, password) 
values(20002, 'Admin 2', 'admin2@gmail.com', '234567890', 'Mumbai', '1234567');

insert into admin(admin_id, username, email, mobile_number, address, password) 
values(20003, 'Admin 3', 'admin3@gmail.com', '345678912', 'Mumbai', '1234567');

insert into admin(admin_id, username, email, mobile_number, address, password) 
values(20004, 'Admin 4', 'admin4@gmail.com', '456789123', 'Mumbai', '1234567');

insert into admin(admin_id, username, email, mobile_number, address, password) 
values(20005, 'Admin 5', 'admin5@gmail.com', '567894567', 'Mumbai', '1234567');



insert into cab(cab_id, car_Type, per_km_rate) 
values(40001, 'Sedan', 5.5);

insert into cab(cab_id, car_Type, per_km_rate) 
values(40002, 'Hachback', 3.5);

insert into cab(cab_id, car_Type, per_km_rate) 
values(40003, 'Sedan', 6);

insert into cab(cab_id, car_Type, per_km_rate) 
values(40004, 'Sedan', 6.5);

insert into cab(cab_id, car_Type, per_km_rate) 
values(40005, 'Hachback', 4);



insert into driver(driver_id, username, email, mobile_number, address, password, cab_id, licence_no, rating) 
values(30001, 'Driver 1', 'driver1@gmail.com', '123456789', 'Mumbai', '1234567', 40001, '3456', 5);

insert into driver(driver_id, username, email, mobile_number, address, password, cab_id, licence_no, rating) 
values(30002, 'Driver 2', 'driver2@gmail.com', '123456789', 'Mumbai', '1234567', 40002, '4567', 3);

insert into driver(driver_id, username, email, mobile_number, address, password, cab_id, licence_no, rating) 
values(30003, 'Driver 3', 'driver3@gmail.com', '123456789', 'Mumbai', '1234567', 40003, '5678', 4.6);

insert into driver(driver_id, username, email, mobile_number, address, password, cab_id, licence_no, rating) 
values(30004, 'Driver 4', 'driver4@gmail.com', '123456789', 'Mumbai', '1234567', 40004, '6789', 4);

insert into driver(driver_id, username, email, mobile_number, address, password, cab_id, licence_no, rating) 
values(30005, 'Driver 5', 'driver5@gmail.com', '123456789', 'Mumbai', '1234567', 40005, '7890', 4.5);



insert into trip_booking(trip_booking_id, distance_in_km, from_date_time, from_location, status, to_date_time, customer_id, driver_id) 
values(50001, 10.5, sysdate(), 'location1', true, sysdate(), 10001, 30001);

insert into trip_booking(trip_booking_id, distance_in_km, from_date_time, from_location, status, to_date_time, customer_id, driver_id) 
values(50002, 12, sysdate(), 'location2', true, sysdate(), 10002, 30001);

insert into trip_booking(trip_booking_id, distance_in_km, from_date_time, from_location, status, to_date_time, customer_id, driver_id) 
values(50003, 5, sysdate(), 'location3', false, sysdate(), 10002, 30002);

insert into trip_booking(trip_booking_id, distance_in_km, from_date_time, from_location, status, to_date_time, customer_id, driver_id) 
values(50004, 9.5, sysdate(), 'location4', true, sysdate(), 10001, 30003);

insert into trip_booking(trip_booking_id, distance_in_km, from_date_time, from_location, status, to_date_time, customer_id, driver_id) 
values(50005, 10, sysdate(), 'location5', false, sysdate(), 10003, 30004);



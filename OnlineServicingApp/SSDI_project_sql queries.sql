Drop database SSDI;
Create database SSDI;
Use SSDI;

create table Login (
username varchar(20),
password varchar(10),
role varchar(10),
Primary key (username));


create table Store (
storeId char(10),
storeName varchar(20),
storeAdd varchar(50),
storeLocation varchar(20),
store_phone_no   char(10),
store_email_id  varchar(30),
manager     varchar(30),
manager_phone_no  char(10),
manager_email_id varchar(30),
Primary key (storeId));


create table Technician (
techId char(10),
techName varchar(20),
techstatus char(10),
no_of_orders int,
tech_email_id   varchar(30),
tech_phone_no  char(10),
store_id char(10),
last_completed_timestamp timestamp,
Primary key (techId),
Foreign key (store_id) references Store(storeId) ON DELETE CASCADE );


create table DeliveryStaff (
deliveryId char(10),
deliveryName varchar(20),
location char(30),
delivery_email_id   varchar(30),
delivery_phone_no  char(10),
store_id char(10),
delivery_add varchar(30),
Primary key (deliveryId),
Foreign key (store_id) references Store(storeId) ON DELETE CASCADE );


create table Product(
prodId char(10),
description varchar(20),
primary key (prodId)
);

create table Customer (
customerId char(10),
customerName varchar(20),
location char(30),
customer_email_id   varchar(30),
customer_phone_no  char(10),
customer_add varchar(30),
Primary key (customerId) );


create table OrderDetails (
orderId char(10),
date_of_order timestamp,
prodId char(10),
make   varchar(30),
tech_id  char(10),
store_id char(10),
customer_id  char(10),
order_status char(10),
delivery_id char(10),
description text,
payment_status char(10),
Primary key (orderId),
Foreign key (store_id) references Store(storeId) ,
Foreign key (prodId) references Product(prodId) ,
Foreign key (customer_id) references customer(customerId) ,
Foreign key (delivery_id) references deliverystaff(deliveryId),
Foreign key (tech_id) references technician(techId));


create table StoreProduct(
storeId char(10),
prodId char(10),
primary key (storeId,prodId),
Foreign key (storeId) references Store(storeId) ,
Foreign key (prodId) references product(prodId) 
);


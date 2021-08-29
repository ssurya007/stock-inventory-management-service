# stock-inventory-management-service
please find below details to run this project in local
server port : 8088
context path : /stock-inventory-management-service

database : h2
database url : http://localhost:8088/stock-inventory-management-service/h2-console/
(Can find DB credentails in local profile)

Validations used : 
three headers used for each endpoint
Header name         possible values
reqChannel ----         IB/MB                 ----- Mandatory
version -----         1.0,1.1,etc             ------- not mandatory
transactionId  -----  any random string ---- mandatory

all values in request body are mandatory for all 3 endpoints

date format ---- yyyy-MM-dd (eg: 2021-08-28)


note: please check port number may be this port number is in use by another application if yes then change in iassignment\src\main\resources\application.properties file .
change this -> server.port=XXXX

http://localhost:8081/customers/without-orders   this url return all those customer who have not ordered anything

http://localhost:8081/customers/save-customer-with-order    this url allow to save the customer information and its order details // 

we run these url in postman and while saving customer information and order detail we use JSON 



{
  "name": "akash",
  "orders": [
    {
      "productname": "watch"
    },
    {
      "productbame": "laptop"
    }
  ]
}


and if we want that customer not order anything then use this JSON 

{
  "name": "akash",
  "orders": [
    
  ]
}


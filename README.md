# Inventory Management Microservice

Inventory Management Microservice created as part of Thoughtworks Workshop. Below services are created till now:

1. Search Inventory details based on ISBN
2. Procure New Book
3. Get Details of Existing Book


# Tech Stack Details

* REST Services - JAX-RS (Jersey)
* Database Access  - JDBI (Skife)
* Bootstrap, packaging , Monitoring - Dropwizard
* Package Http Server - Eclipse Jetty (Embedded by dropwizard)
* Database - Apache Derby 


# Running the Application

Note: DAO's are not stubbed yet, hence unit tests require existing database. If mvn package is executed without providing correct jdbc url,build will fail.

* To package the application run 

mvn package

* To the run the inventory service, run below command

  java -jar target/inventory-0.0.1-SNAPSHOT.jar config.yml
  

* Server monitoring can be done through following URL:

http://localhost:8080/admin

* REST End Point Details: 

1. http://localhost:8080/application/books?isbn=12-345-678-90-1

2.http://localhost:8080/application/ProcurementDetails?bookid=5

3. curl -H "Content-Type: application/json" -X POST -d '{"isbn":"12-345-678-90-1","shelfDetails":"23", "bookStatus":"A"}' http://localhost:8080/application/ProcurementDetails


# spacebardemo
spacebardemo

spring boot project
implemented mechanism for Redis cache. JPA (with views) , entity manager (sql with between criteria) to query mysql database
Spring security-basic htttp 


unit test for controller using mockito
integration test using cucumber( this needs to be seperate project


Project is divided into two modules ( two seperate brances)
  Projects:
Spring-boot-demo-core à this is the core library for the project. It consist of DTO’s ( data transfer object/ models required for multiple projects- micro services)
Spring-boot-demo- frank ( it has redis model, repository )

 

For testing 2 different framework has been used

1)      Cucumber for integration test ( test need the spring boot project running)- this has to be seperate project
2)      Unit testing is done by mockito ( by mocking up the service)

Unit test is  for controller via  mockito
Integration test is via running the endpoint and hitting the same for correctness of object 

Future enhancement : is the remove the service layer out of the project ( similar to to demo core)

also I have attached database schema for JPA repository​/ database dump on  branch


Currently the date filters are hardcoded it can be fetched via POSTbody
two function are there one function is used for query'ing the User played Max number via view whereas other is via sql query in service

Please find git URL
https://github.com/jagrutifrankdemo/spacebardemo​

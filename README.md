# Spring boot API to retrieve, register, update, and delete a User


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#How-to-use-the-API">How to use the API</a>
      <ul>
        <li><a href="#DB">DB</a></li>
        <li><a href="#Services">Services</a></li>
        <li><a href="#Logging">Logging</a></li>
        <li><a href="#Unit-Tests">Unit Tests</a></li>
      </ul>
    </li>
     <li>
      <a href="#conclusion">Conclusion</a>
    </li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

the main purpuse of the project is to create a Spring Boot API that allows: 

* Registration of a user
* Displaying the details of that registration
* Updating the user informations
* Deleting a user

<!-- Built With -->
### Built With

this project is built using :

* [Java 8](https://docs.oracle.com/javase/8/docs/)
* [Springboot](https://spring.io/projects/spring-boot)
* [JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
* [Hibernate](https://hibernate.org/)
* [Spring AOP](https://docs.spring.io/spring-framework/docs/2.5.x/reference/aop.html)
* [H2 Database](https://www.h2database.com/html/main.html)


<!-- How to use the API -->
## How to use the API

I have used H2 as in memory database and rest web services. 
Project can be executed as follows:

* mvn clean
* mvn install
* mvn spring-boot:run

After the project is up and running DB, Services can be accessed as follows:

* DB :

Access http://localhost:8080/h2-ui with schema jdbc:h2:mem:testdb connect and see tables data.

* Services :

  * User

    * POST localhost:8080/user
    * GET localhost:8080/user/{id}
    * PUT localhost:8080/user/{id}
    * DELETE localhost:8080/user/{id}

* Logging :
    
Thanks to Spring AOP the inputs and outputs are logged in every execution as well as the processing time. 
Those logs are shown in the console of our IDE.
In this project, we used Spring AOP instead of AspectJ because It is simpler to configurate, since we don't have to use LTW (load-time weaving) or the AspectJ compiler, and in this case it provides the functionalities we need.

* Unit Tests :

For the unit tests, it can be run under the package test.java.com.myproject.technicaltest.TechnicalTestApplicationTests, using junit.

<!-- Conclusion -->
## Conclusion

This project still can be improved by adding different functionalities such as :

* Events Publishing
* Access Restriction to add more security

That can be procided easily thanks to the spring AOP.




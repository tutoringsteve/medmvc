# medmvc

This was my very first Spring Boot / Spring framework project. There was a ton of front loaded learning to do about the framework, which took up most of my production time, but I feel I learned a LOT and was very pleased with the experience overall.

## Summary
This project creates an in-memory data base of health care domain specific entities Patients, Doctors, and Diseases, each represented as POJOs (Plain Old Java Objects). It maps their many-to-many relationships, initializes the data base with 3 doctors, 3 diseases, and 3 patients, assigning relationships between each. It then uses a Spring MVC pattern to generate different views from the data as html pages by accessing specific URLs (currently from the local host.)

## How to use
1. Clone the repo to an IDE of your choosing. This project was made entirely in intellij community edition.
2. Run the program from the main argument in the `MedmvcApplication` which contains the main() method.
3. Go to the local host http://localhost:8080/patients , http://localhost:8080/doctors, and http://localhost:8080/diseases to see the three different views that can currently be generated.
4. Optionally you may look at the string representation of the data which is printed to console in a JSON like format.

### Aside
The debugging console has been enabled in the application.properties file so that you can actually get a nice gui representation of the raw data base at http://localhost:8080/h2-console. In the console output look for a line like the following:
```
o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:2ad35653-231d-4e9d-9f7a-bd4afab5a6c7'
```
Copy the `'jdbc:h2:mem:2ad35653-231d-4e9d-9f7a-bd4afab5a6c7'` string into the JDBC URL: field in the h2-console and press connect to view the database where you can also run SQL queries.

You may find that your port 8080 is being used. You can either configure the tomcat server to use a different port or you may find and kill any processes which are listening on that port.

## Technologies used
The dependencies were obtained using the awesome Spring initializr tool [spring initializr](https://start.spring.io/). The following four Spring Starters were used.
1. Spring Web : for making web apps
2. Spring Data JPA : for managing SQL DB connections
3. H2 database : a lightweight in-memory SQL database
4. Thymeleaf : A template engine that helps generate HTML, e.g. for viewing some data on a web page.

Git console was used to manage version control and uploading to the upstream repo on GitHub.

## Wishes for future release
I would like to do the following in no particular order.
- Add a GUI interface for password enabled login, and forms to add new patients, diseases, and doctors.
- Enhance the output to something better than simple HTML tables
- Not use thymeleaf
- have the view code be more scalable to arbitrary data sizes and give a pretty interface for viewing SQL queries on the data base.

## Ending notes
Regardless of whether I get the internship based off my interview and this project I wanted to thank you for pushing me to learn this awesome technology. I am going to be spending the next many months deep diving into the Spring world.


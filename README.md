# Secret Santa Draw Generator

This is a simple rest api that generates a secret santa draw for a group of people. It will send an email to each person with the name of the person they are buying a gift for and the gift suggestions they have provided.

## Motivation, Objective and Goals

First, the idea was to create a simple santa secret draw generator. 
Then, I decided to make it a rest api so that it could be used by other applications. 
The goal is to have a simple rest api that can be used to generate a secret santa draw for a group of people.

Some goals for this project are:
- [ ] Send email to each person with the name of the person they are buying a gift for and the gift suggestions they have provided.
- [ ] Dockerize the application
- [ ] Create a postgress database to store the data
- [ ] Create a docker-compose file to run the application and the database
- [ ] Create a frontend application to consume the rest api (another project)


## Getting Started

These instructions will give you a copy of the project up and running on
your local machine for development and testing purposes. See deployment
for notes on deploying the project on a live system.

### Prerequisites

Requirements for the software and other tools to build, test and push
- [Java 17](https://jdk.java.net/archive/)

### Running the application

On the root folder of the project run the following command to start the application:

    mvnw spring-boot:run


## Running the tests

On the root folder of the project run the following command to run the tests:

    mvnw clean test

## Authors

- **Bruno Val** - [Github](https://github.com/valBruno)

## License



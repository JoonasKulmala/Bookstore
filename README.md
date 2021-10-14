# Bookstore | Joonas Kulmala

![GitHub top language](https://img.shields.io/github/languages/top/JoonasKulmala/Bookstore)
![Website](https://img.shields.io/badge/-Spring-brightgreen)

- [Bookstore | Joonas Kulmala](#bookstore--joonas-kulmala)
  - [Project description](#project-description)
  - [Requirements](#requirements)
  - [Current features](#current-features)
    - [Authentication](#authentication)
    - [CRUD functionality](#crud-functionality)
    - [REST API](#rest-api)
  - [License](#license)

## Project description

Palvelinohjelmointi - SWD4TN020

This repository is being updated weekly. It contains the **newest** build **only**.

For previous iterations visit my other repository [Palvelinohjelmointi | Joonas Kulmala](https://github.com/JoonasKulmala/Palvelinohjelmointi).

***Live Build*** deployed via [Heroku - joonaskulmala.bookstore](https://joonaskulmala-bookstore.herokuapp.com/booklist)

## Requirements

`Java 11` is required to run this application.

Run the main application file [BookstoreApplication.java](src/main/java/fi/kulmala/Bookstore/BookstoreApplication.java) and open browser at port 8080

    localhost:8080

## Current features

### Authentication

Two users are initialized on application startup:

- user/user (role=user)
- admin/admin (role=admin)

Application has the following authentication services:

- registration
- login

<kbd>
  <img src="Resources/login.png", width=200 height=100%>
</kbd>

### CRUD functionality

Navigate to main view

    localhost:8080/booklist

<kbd>
  <img src="Resources/booklist.png", width=600 height=100%>
</kbd>

### REST API

Rest API endpoints are available at

    localhost:8080/api

<kbd>
  <img src="Resources/api.png", width=350 height=100%>
</kbd>

## License

Repository and all its contents distributed under [MIT](LICENSE) license.

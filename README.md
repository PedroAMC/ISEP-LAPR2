# README #

This repository contains the integrative project developed in the ambit of LAPR2 course, ISEP 2021.

This application is intended to manage and overview the vaccination process performed by 
multiple vaccinations centers as well as many health care professionals, from the creation of 
centers and the vaccination process, to the viewing of statistics. 

It also contains multiple brute-force and sorting algorithms, used to analyze the performance of a center, with their complexity analised using discrete mathematics theorems.

This application was developed using agile and GRASP methodologies and all the developed functionalities can be viewed in the [docs](docs) folder, in the directory of their respective sprint.

### User Stories developed by me
1. Sprint B - [US11:](docs/SprintB/US11) As an administrator, I want to get a list of Employees with a given function/role.
2. Sprint C - [US04:](docs/SprintC/US04) As a receptionist at a vaccination center, I want to register the arrival of a SNS user
to take the vaccine
3. Sprint D - [US16:](docs/SprintD/US16) As a center coordinator, I intend to analyze the performance of a center.

### Domain Model
![domain model](docs/SprintD/DM/DM.svg)
### Application Overview

The following sequence diagram graphically represents the intended flow for the application where there is a clear separation (decoupling) between the domain classes and the user interaction classes (_user interface_). This decoupling is performed by classes with the suffix _Controller_.

 
![GeneralOverview](docs/UI_ControllerOverview.svg)

The execution of some functionalities by users must be preceded and verified by an authorization mechanism based on users' roles.
This verification can be carried out as follows:


![CheckingUserAuthorization](docs/ControllerCheckingUserAuthorization.svg)

Users' authentication and authorization processes are reutilizing an external component called **_AuthLib_**.
Documentation regarding this component is available [here](docs/Auth/README.md).


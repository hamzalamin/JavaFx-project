# JavaFX Project - Product Sales Management System

This is a JavaFX-based application designed to manage product sales. It provides functionalities such as product catalog management, order processing, client management, and billing. The application connects to a PostgreSQL database for data storage and retrieval.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Setup](#setup)
3. [Building the Project](#building-the-project)
4. [Running the Application](#running-the-application)
5. [Project Structure](#project-structure)
6. [Database Configuration](#database-configuration)
7. [Features](#features)
8. [Technologies Used](#technologies-used)
9. [Troubleshooting](#troubleshooting)
10. [Contributing](#contributing)
11. [License](#license)
12. [Contact](#contact)

## Prerequisites

Before running the project, ensure you have the following installed on your system:

- **Java Development Kit (JDK) 22**: The project is built using Java 22. You can download the JDK from the [official Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html).
- **Apache Maven**: Maven is used for building and managing the project. Download it from the [Apache Maven website](https://maven.apache.org/download.cgi).
- **PostgreSQL**: The application uses PostgreSQL as the database. Download and install PostgreSQL from the [official PostgreSQL website](https://www.postgresql.org/download/).
- **Git** (optional): If you plan to clone the repository, you’ll need Git. Download it from the [Git website](https://git-scm.com/downloads).

## Setup

### 1. Clone the Repository
If you are using Git, clone the repository to your local machine:

```bash
git clone https://github.com/your-username/JavaFx-project.git
cd JavaFx-project
```
## Set Up the PostgreSQL Database

- Install PostgreSQL and ensure the PostgreSQL service is running.
- Create a new database named `javafx_project`.
- Update the database connection details in the application configuration file (if applicable).

## Building the Project

To build the project, follow these steps:

### 1. Navigate to the Project Directory

```bash
cd JavaFx-project
```
### 2. Build the Project Using Maven

Run the following command to clean and package the project:

```bash
mvn clean package
```
This will generate a JAR file in the target directory:
JavaFx-project-1.0-SNAPSHOT-jar-with-dependencies.jar

## Project Structure

The project is organized as follows:

```bash
JavaFx-project/
├── src/
│   ├── main/
│   │   ├── java/                  # Java source files
│   │   │   ├── com.wora.javafxproject/
│   │   │   │   ├── config/   
│   │   │   │   ├── controllers/   
│   │   │   │   ├── models/
│   │   │   │   ├── utils/              
│   │   │   │   ├── repositories/      
│   │   └── resources/
│   │         └── views/            
│   └── test/                      
├── target/
├── pom.xml                         
└── README.md                      

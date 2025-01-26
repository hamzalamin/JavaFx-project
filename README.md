#!/bin/bash

# File name for the README
README_FILE="README.md"

# Writing the content to the README file
echo "# JavaFX Project - Product Sales Management System" > $README_FILE
echo "" >> $README_FILE
echo "This is a JavaFX-based application designed to manage product sales. It provides functionalities such as product catalog management, order processing, client management, and billing. The application connects to a PostgreSQL database for data storage and retrieval." >> $README_FILE
echo "" >> $README_FILE

# Table of contents
echo "## Table of Contents" >> $README_FILE
echo "1. [Prerequisites](#prerequisites)" >> $README_FILE
echo "2. [Setup](#setup)" >> $README_FILE
echo "3. [Building the Project](#building-the-project)" >> $README_FILE
echo "4. [Running the Application](#running-the-application)" >> $README_FILE
echo "5. [Project Structure](#project-structure)" >> $README_FILE
echo "6. [Database Configuration](#database-configuration)" >> $README_FILE
echo "7. [Features](#features)" >> $README_FILE
echo "8. [Technologies Used](#technologies-used)" >> $README_FILE
echo "9. [Troubleshooting](#troubleshooting)" >> $README_FILE
echo "10. [Contributing](#contributing)" >> $README_FILE
echo "11. [License](#license)" >> $README_FILE
echo "12. [Contact](#contact)" >> $README_FILE
echo "" >> $README_FILE

# Prerequisites section
echo "## Prerequisites" >> $README_FILE
echo "" >> $README_FILE
echo "Before running the project, ensure you have the following installed on your system:" >> $README_FILE
echo "" >> $README_FILE
echo "- **Java Development Kit (JDK) 22**: The project is built using Java 22. You can download the JDK from the [official Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html)." >> $README_FILE
echo "- **Apache Maven**: Maven is used for building and managing the project. Download it from the [Apache Maven website](https://maven.apache.org/download.cgi)." >> $README_FILE
echo "- **PostgreSQL**: The application uses PostgreSQL as the database. Download and install PostgreSQL from the [official PostgreSQL website](https://www.postgresql.org/download/)." >> $README_FILE
echo "- **Git** (optional): If you plan to clone the repository, you’ll need Git. Download it from the [Git website](https://git-scm.com/downloads)." >> $README_FILE
echo "" >> $README_FILE

# Setup section
echo "## Setup" >> $README_FILE
echo "" >> $README_FILE
echo "### 1. Clone the Repository" >> $README_FILE
echo "   If you are using Git, clone the repository to your local machine:" >> $README_FILE
echo "   ```bash" >> $README_FILE
echo "   git clone https://github.com/your-username/JavaFx-project.git" >> $README_FILE
echo "   cd JavaFx-project" >> $README_FILE
echo "   ```" >> $README_FILE
echo "2. Set Up the PostgreSQL Database" >> $README_FILE
echo "   - Install PostgreSQL and ensure the PostgreSQL service is running." >> $README_FILE
echo "   - Create a new database named `javafx_project`." >> $README_FILE
echo "   - Update the database connection details in the application configuration file (if applicable)." >> $README_FILE
echo "" >> $README_FILE

# Building the Project section
echo "## Building the Project" >> $README_FILE
echo "" >> $README_FILE
echo "To build the project, follow these steps:" >> $README_FILE
echo "" >> $README_FILE
echo "Navigate to the project directory:" >> $README_FILE
echo "   ```bash" >> $README_FILE
echo "   cd JavaFx-project" >> $README_FILE
echo "   ```" >> $README_FILE
echo "Build the project using Maven:" >> $README_FILE
echo "   Run the following command to clean and package the project:" >> $README_FILE
echo "   ```bash" >> $README_FILE
echo "   mvn clean package" >> $README_FILE
echo "   ```" >> $README_FILE
echo "This will generate a JAR file in the target directory:" >> $README_FILE
echo "   `JavaFx-project-1.0-SNAPSHOT-jar-with-dependencies.jar`" >> $README_FILE
echo "" >> $README_FILE

# Running the Application section
echo "## Running the Application" >> $README_FILE
echo "" >> $README_FILE
echo "1. Run the JAR File" >> $README_FILE
echo "   Navigate to the target directory and run the following command:" >> $README_FILE
echo "   ```bash" >> $README_FILE
echo "   cd target" >> $README_FILE
echo "   java -jar JavaFx-project-1.0-SNAPSHOT-jar-with-dependencies.jar" >> $README_FILE
echo "   ```" >> $README_FILE
echo "2. Run from the Root Directory (Optional)" >> $README_FILE
echo "   If you want to run the JAR file from the root directory, copy it there:" >> $README_FILE
echo "   ```bash" >> $README_FILE
echo "   copy target\\JavaFx-project-1.0-SNAPSHOT-jar-with-dependencies.jar ." >> $README_FILE
echo "   java -jar JavaFx-project-1.0-SNAPSHOT-jar-with-dependencies.jar" >> $README_FILE
echo "   ```" >> $README_FILE
echo "" >> $README_FILE

# Project Structure section
echo "## Project Structure" >> $README_FILE
echo "The project is organized as follows:" >> $README_FILE
echo "```" >> $README_FILE
echo "JavaFx-project/" >> $README_FILE
echo "├── src/" >> $README_FILE
echo "│   ├── main/" >> $README_FILE
echo "│   │   ├── java/                  # Java source files" >> $README_FILE
echo "│   │   │   ├── com.wora.javafxproject/" >> $README_FILE
echo "│   │   │   │   ├── controllers/   # Controller classes for JavaFX" >> $README_FILE
echo "│   │   │   │   ├── models/        # Data models (e.g., Product, Order)" >> $README_FILE
echo "│   │   │   │   ├── services/      # Business logic and database services" >> $README_FILE
echo "│   │   │   │   └── views/         # FXML files for the user interface" >> $README_FILE
echo "│   │   └── resources/             # Resource files (e.g., FXML, CSS, images)" >> $README_FILE
echo "│   └── test/                      # Unit and integration tests" >> $README_FILE
echo "├── target/                        # Compiled JAR files" >> $README_FILE
echo "├── pom.xml                        # Maven configuration file" >> $README_FILE
echo "└── README.md                      # Project documentation" >> $README_FILE
echo "```" >> $README_FILE

# Output a message to indicate that the README file has been created
echo "README.md has been generated successfully."

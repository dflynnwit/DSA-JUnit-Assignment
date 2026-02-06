# DSA-JUnit-Assignment

Data Structures and Algorithms JUnit 5 Testing Assignment

## Project Description

This is a Maven-based Java 17 project set up for JUnit 5 testing assignments focused on Data Structures and Algorithms.

## Prerequisites

- Java 17 or higher
- Apache Maven 3.6 or higher

## Project Structure

```
DSA-JUnit-Assignment/
├── src/
│   ├── main/
│   │   ├── java/          # Source code
│   │   └── resources/     # Application resources
│   └── test/
│       ├── java/          # Test code
│       └── resources/     # Test resources
├── pom.xml                # Maven configuration
└── README.md              # This file
```

## Building the Project

To compile the project:

```bash
mvn compile
```

## Running Tests

To run all tests:

```bash
mvn test
```

To run a specific test class:

```bash
mvn test -Dtest=YourTestClassName
```

## IDE Setup

### IntelliJ IDEA

1. Open IntelliJ IDEA
2. Select "File" → "Open"
3. Navigate to the project directory and select the `pom.xml` file
4. Click "Open as Project"
5. IntelliJ will automatically import the Maven project and configure JUnit 5

### Eclipse

1. Open Eclipse
2. Select "File" → "Import"
3. Choose "Maven" → "Existing Maven Projects"
4. Select the project directory
5. Click "Finish"

## Dependencies

- JUnit Jupiter 5.10.1 (JUnit 5)
  - junit-jupiter-api: For writing tests
  - junit-jupiter-engine: For running tests
  - junit-jupiter-params: For parameterized tests

## Maven Commands

- `mvn clean`: Clean the project
- `mvn compile`: Compile the source code
- `mvn test`: Run tests
- `mvn package`: Package the project into a JAR file
- `mvn clean install`: Clean, compile, test, and install the project

## License

This project is licensed under the terms included in the LICENSE file.

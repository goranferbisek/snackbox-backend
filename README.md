# Snackbox Backend

A Spring Boot application for a food delivery service

## Prerequisites

- Java 21
- MySQL 8.0+
- Gradle (wrapper included)

## Configuration

### JWT Secret Configuration

The application uses JWT for authentication. Configure the JWT secret by setting the `SNACKBOX_JWT_SECRET` environment variable:

```bash
export SNACKBOX_JWT_SECRET=your-secure-secret-key-here
```

If not set, the application will use a default value (not recommended for production).

The JWT secret is configured in `src/main/resources/application.properties`:
```properties
jwt.secret=${SNACKBOX_JWT_SECRET:lkad9k73234asldkflskdfu909s09u09a0s9df}
```

## Building the Application

Build the project using Gradle wrapper:

```bash
./gradlew build
```

## Running the Application

### Using the JAR file

Build and run the JAR:

```bash
./gradlew build
java -jar build/libs/snackbox-api.jar
```

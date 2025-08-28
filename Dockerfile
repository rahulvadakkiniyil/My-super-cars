# Stage 1: Build the JAR using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and download dependencies first (better caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run the built JAR
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/supercars-1.0.0.jar app.jar

# Expose app port (change if needed)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]

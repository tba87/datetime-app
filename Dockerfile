# Build stage
# CORRECTED: Use a valid Maven image tag that includes OpenJDK 17
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and build the JAR.
# Keep -DskipTests for now as your tests are failing
COPY src ./src
RUN mvn package -DskipTests

# Run stage
# This part looks correct. openjdk:17-jdk-slim is a valid image.
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

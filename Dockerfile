# Use the latest stable Maven with OpenJDK 17 for the build stage
FROM maven:3.9.6-openjdk-17 AS build # Updated Maven version
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and build the JAR.
# Keep -DskipTests if you still want to bypass test execution during Docker build.
# If tests are fixed, remove -DskipTests to ensure tests run during image build.
COPY src ./src
RUN mvn package -DskipTests

# Run stage
# Using a slim JDK for the final image to keep it small
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR from the build stage
# The wildcard is generally fine here for single-module projects
COPY --from=build /app/target/*.jar app.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

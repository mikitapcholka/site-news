# Step 1: Use Maven 4.0.0 with OpenJDK 23 to build the app
FROM maven:3.9.9-eclipse-temurin-23-alpine AS build

# Set the working directory in the container
WORKDIR /app
#WORKDIR /src

# Copy the pom.xml and download dependencies to leverage Docker cache
COPY pom.xml .

# Download dependencies (This layer will be cached if unchanged)
RUN mvn dependency:go-offline

# Copy the entire project to the container
COPY . .

# Step 2: Build the Spring Boot application
RUN mvn clean package -DskipTests

# Step 3: Create a new image to run the Spring Boot application
FROM eclipse-temurin:23

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port that the Spring Boot app will run on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
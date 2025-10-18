# Stage 1: Build the application
FROM maven:3.9.2-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies first (caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create a lightweight runtime image
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose ports (adjust as needed)
# 50051 for gRPC, 8080 for REST (optional)
EXPOSE 8080 

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Expone el puerto 8082
EXPOSE 8082

# Copy the jar file from the local machine to the container
COPY target/User_Service-0.0.1-SNAPSHOT.jar /app/app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

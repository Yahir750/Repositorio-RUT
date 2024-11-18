FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/Product_Service-0.0.1-SNAPSHOT.jar app.jar
# Expone el puerto 8081
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]

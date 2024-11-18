FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/Cart_Service-0.0.1-SNAPSHOT.jar-SNAPSHOT.jar app.jar
# Expone el puerto 8081
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/app.jar"]

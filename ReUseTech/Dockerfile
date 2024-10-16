FROM openjdk:17

# Copia el JAR de la aplicación al contenedor
COPY target/springboot--mysql-docker.jar springboot--mysql-docker.jar

# Establece el punto de entrada
ENTRYPOINT ["java", "-jar", "springboot--mysql-docker.jar"]

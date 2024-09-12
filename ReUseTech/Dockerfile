# Usar una imagen
FROM openjdk:17-jdk-alpine

# Crear un directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR
COPY target/ReUseTech-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080 para que pueda ser accedido desde fuera del contenedor
EXPOSE 8085

# Definir el comando de entrada para ejecutar la aplicación cuando se inicie el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]


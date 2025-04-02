# Usa una imagen de OpenJDK 11 para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado al contenedo
COPY E-Fit_API/target/EFit_API-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 (puedes cambiarlo si usas otro puerto en tu aplicación)
EXPOSE 8080

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

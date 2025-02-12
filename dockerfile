# Usar una imagen base con JDK 17
FROM openjdk:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado por Maven
# Asegúrate de que la ruta de origen sea correcta y que el archivo exista
COPY build/libs/pokemonTCGP-0.0.1-SNAPSHOT.jar .

# Puerto expuesto
EXPOSE 8080

# Comando para ejecutar la aplicación
# Asegúrate de que el nombre del archivo JAR coincida exactamente
ENTRYPOINT ["java", "-jar", "pokemonTCGP-0.0.1-SNAPSHOT.jar"]
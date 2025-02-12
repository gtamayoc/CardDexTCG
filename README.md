# 📌 CardDexTCG

## 📖 Descripción

**CardDexTCG** es una aplicación diseñada para organizar, gestionar y compartir colecciones de cartas de Pokémon TCG. Permite a los usuarios visualizar su colección, completar sets más fácilmente y ver las cartas que sus amigos poseen o necesitan.

## 🚀 Objetivo del Proyecto

Desarrollar una plataforma eficiente para la gestión de cartas de Pokémon TCG, integrando una API para obtener información actualizada y ofreciendo herramientas para mejorar la experiencia del usuario en la organización e intercambio de cartas.

---

## 🛠️ Tecnologías Utilizadas

### 🔹 Backend

- **Lenguaje:** Java 17
- **Framework:** Spring Boot 3
- **Base de Datos:** PostgreSQL (producción), H2 (desarrollo/pruebas)
- **ORM:** JPA (Jakarta Persistence)
- **Seguridad:** Spring Security
- **Documentación:** SpringDoc OpenAPI + Swagger

### 🔹 Dependencias Clave

| Dependencia                    | Descripción                                      |
| ------------------------------ | ------------------------------------------------ |
| `spring-boot-starter-data-jpa` | Gestión de persistencia con JPA                  |
| `spring-boot-starter-web`      | Creación de API REST                             |
| `spring-boot-starter-security` | Autenticación y autorización                     |
| `postgresql`                   | Conector JDBC para PostgreSQL                    |
| `springdoc-openapi-ui`         | Documentación automática de API                  |
| `spring-boot-devtools`         | Facilita el desarrollo con recarga automática    |
| `lombok`                       | Reducción de código repetitivo (getters/setters) |

---

## ⚙️ Funcionalidades Principales (Alpha)

✅ Consulta a la API de Pokémon TCG.\
🚧 **Pendiente:** Implementación de guardado de cartas en la base de datos.\
🚧 **Pendiente:** Mejoras en la accesibilidad y experiencia de usuario.

---

## 📂 Estructura del Proyecto

```
CardDexTCG/
│── src/
│   ├── main/
│   │   ├── java/com/carddextcg/
│   │   │   ├── controller/  # Controladores de API
│   │   │   ├── service/     # Lógica de negocio
│   │   │   ├── repository/  # Acceso a la base de datos
│   │   │   ├── model/       # Entidades JPA
│   │   │   ├── dto/         # Data Transfer Objects (MapStruct)
│   │   │   ├── config/      # Configuraciones generales
│   │   ├── resources/
│   │   │   ├── application.properties  # Configuración de la app
│── pom.xml  # Dependencias Maven
│── README.md  # Documentación
```

---

## 📌 Instalación y Configuración

### 1️⃣ Prerequisitos

- JDK 17 o superior
- Maven 3.8+
- Docker y Docker Compose
- PostgreSQL configurado (si no se usa Docker)

### 2️⃣ Clonar el repositorio

```sh
git clone https://github.com/gtamayoc/CardDexTCG.git
cd CardDexTCG
```

### 3️⃣ Configurar la Base de Datos

Si se usa PostgreSQL local, modificar `application.properties` con las credenciales:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pokemondb
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 4️⃣ Compilar y ejecutar

```sh
mvn spring-boot:run
```

---

## 🐳 Uso con Docker

Se recomienda usar **Docker** y **Docker Compose** para desplegar la aplicación junto con la base de datos PostgreSQL.

### 📄 Archivo `Dockerfile` (básico)
```dockerfile
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
```

### 📄 Archivo `docker-compose.yml`
```yaml
version: '3.8'

services:
  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/pokemondb
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: password
    networks:
      - pokemon-network

  db:
    image: postgres:13
    environment:
      POSTGRES_DB: pokemondb
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: password
    ports:
      - "5432:5432"
    volumes:
      - postgres-data:/var/lib/postgresql/data
    networks:
      - pokemon-network

volumes:
  postgres-data:

networks:
  pokemon-network:
```

Para iniciar los contenedores:
```sh
docker-compose up -d
```

---

## 📜 Créditos y Agradecimientos

Este proyecto utiliza librerías de código abierto que han facilitado su desarrollo:

- **Spring Boot** ([https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot))
- **Spring Security** ([https://spring.io/projects/spring-security](https://spring.io/projects/spring-security))
- **SpringDoc OpenAPI** ([https://springdoc.org/](https://springdoc.org/))

Agradecimientos a la comunidad de desarrolladores por su apoyo y contribuciones al ecosistema open-source.

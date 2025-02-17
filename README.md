# Spring Boot CRUD con PostgreSQL

Este es un proyecto simple de una API REST con Spring Boot y PostgreSQL.

## Tecnologías Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok

### Construir y ejecutar
```sh
mvn clean install
mvn spring-boot:run
```

## Endpoints de la API

### Usuarios (`/api/v1/users`)

| Método | Endpoint            | Descripción               |
|--------|---------------------|---------------------------|
| GET    | `/api/v1/users`     | Listar todos los usuarios |
| GET    | `/api/v1/users/{id}`| Obtener un usuario por ID |
| POST   | `/api/v1/users`     | Crear un nuevo usuario    |
| PUT    | `/api/v1/users/{id}`| Actualizar un usuario     |
| DELETE | `/api/v1/users/{id}`| Eliminar un usuario       |


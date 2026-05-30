# Comparativa de Paradigmas de Programación - Spring Boot

## Descripción

Este proyecto fue desarrollado en Spring Boot 3.5.14 con el objetivo de comparar dos formas de programación: el paradigma imperativo y el paradigma funcional.

La aplicación simula el procesamiento de 10.000 registros de equipos tecnológicos de laboratorio para generar reportes sobre disponibilidad y valoración de inventario.

Además, se utilizó una arquitectura por capas similar a la utilizada en el proyecto ESPE-Plus.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.14
- Gradle
- REST API
- Streams API
- Docker
- PostgreSQL
- pgAdmin
- Spring Data JPA
- Hibernate

---

## Arquitectura implementada

El proyecto fue organizado utilizando las siguientes capas:

- entity
- dto
- service
- web.controller
- ai

Cada capa tiene una responsabilidad específica para mantener el código más ordenado y fácil de entender.

---

## Funcionalidades

El sistema permite:

- Generar 10.000 registros de hardware.
- Filtrar equipos activos comprados en los últimos 5 años.
- Agrupar equipos por categoría.
- Calcular el valor total por categoría.
- Calcular el promedio de precios por categoría.
- Obtener el equipo más costoso de cada categoría.
- Generar un resumen dinámico del inventario.
- Crear automáticamente la tabla espemovies utilizando JPA.
- Conectarse a PostgreSQL mediante Docker.
- Administrar la base de datos mediante pgAdmin.

---

## Base de Datos

Para este proyecto se utilizó PostgreSQL ejecutándose en contenedores Docker.

La tabla espemovies no fue creada manualmente, sino que fue generada automáticamente por Hibernate y JPA a partir de la entidad HardwareEntity.

---

## Endpoints REST

### Paradigma Imperativo

```txt
GET /inventario/imperativo
```

### Paradigma Funcional

```txt
GET /inventario/funcional
```

### Resumen AI

```txt
GET /inventario/resumen-ai
```

---

## Comparación de Paradigmas

### Paradigma Imperativo

- Utiliza estructuras tradicionales como for e if.
- Permite controlar paso a paso el proceso.
- Requiere más líneas de código.
- Es más fácil de entender para quienes están empezando.

### Paradigma Funcional

- Utiliza Streams API y Collectors.
- Reduce la cantidad de código.
- Hace las operaciones más compactas.
- Facilita el mantenimiento del programa.

### Conclusión

Ambos enfoques permiten resolver el mismo problema. El paradigma imperativo ofrece mayor control sobre el proceso, mientras que el paradigma funcional permite escribir código más corto y organizado.

---

## Ejecución del proyecto

1. Clonar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Ejecutar:

```bash
docker compose up -d
```

4. Verificar que PostgreSQL y pgAdmin estén funcionando.
5. Ejecutar la clase InventarioApplication.
6. Probar los endpoints desde el navegador o Postman.

---

## Autor

Juan Quinteros
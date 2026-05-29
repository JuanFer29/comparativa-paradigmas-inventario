# Comparativa de Paradigmas de Programación - Spring Boot

## Descripción

Proyecto desarrollado en Spring Boot 3.5.14 para comparar el paradigma imperativo y el paradigma funcional mediante el procesamiento de 10,000 registros de hardware del inventario tecnológico de laboratorios.

La aplicación implementa una arquitectura por capas utilizando Controller, Service, Entity, DTO y AI Service.

---

## Tecnologías utilizadas

* Java 21
* Spring Boot 3.5.14
* Gradle
* REST API
* Streams API

---

## Arquitectura implementada

El proyecto fue organizado utilizando las siguientes capas:

* entity
* dto
* service
* web.controller
* ai

---

## Funcionalidades

El sistema permite:

* Generar 10,000 registros de hardware.
* Filtrar equipos activos adquiridos en los últimos 5 años.
* Agrupar equipos por categoría.
* Calcular total y promedio de precios.
* Obtener el equipo más costoso por categoría.
* Generar un resumen dinámico del inventario.

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

### Imperativo

* Uso de estructuras tradicionales (`for`, `if`, acumuladores).
* Mayor control del flujo.
* Más líneas de código.

### Funcional

* Uso de Streams API.
* Código más limpio y compacto.
* Mayor facilidad de mantenimiento.

---

## Ejecución del proyecto

1. Clonar repositorio.
2. Abrir proyecto en IntelliJ IDEA.
3. Ejecutar `InventarioApplication`.
4. Acceder a los endpoints desde el navegador.

---

## Autor

Juan Quinteros

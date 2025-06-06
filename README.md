# ProyectoSGA-FPOE

## Descripción General

**ProyectoSGA-FPOE** es una aplicación web desarrollada en Java y HTML, diseñada para simular el proceso de matrícula académica de la Universidad del Valle. El sistema ofrece una interfaz intuitiva y un backend robusto, permitiendo la gestión de docentes, programas, y cupos académicos, entre otras funcionalidades orientadas a la administración educativa.

## Funcionalidad Destacada

- **Gestión de matrícula académica:** Simula el proceso real de inscripción y administración de estudiantes, docentes y programas.
- **Administración de docentes y programas:** Permite crear, listar y gestionar docentes y programas, con operaciones CRUD implementadas.
- **Interfaz web moderna:** Utiliza XHTML y PrimeFaces para una experiencia de usuario rica y dinámica.
- **Persistencia robusta:** Implementa JPA (Jakarta Persistence) para la gestión de entidades y operaciones con bases de datos relacionales.
- **Mensajería y validaciones:** Uso de mensajes en la interfaz para notificar éxitos o errores en las operaciones realizadas.
- **Pruebas automatizadas:** Soporte para pruebas unitarias con JUnit Jupiter.

## Dependencias y Tecnologías

El proyecto utiliza las siguientes dependencias y tecnologías principales (ver más detalles en `build.gradle`):

- **Java** – Lenguaje principal de programación.
- **Jakarta EE (jakarta.jakartaee-api:9.1.0)** – API para aplicaciones empresariales.
- **PrimeFaces (primefaces:12.0.0:jakarta)** – Componentes UI para JavaServer Faces (JSF).
- **GlassFish Server** – Servidor de aplicaciones recomendado para desplegar la aplicación.
- **Jakarta Persistence API (jakarta.persistence-api:3.2.0-M2)** – Manejo de persistencia y entidades JPA.
- **EclipseLink (org.eclipse.persistence.jpa:4.0.2)** – Implementación de JPA utilizada para la persistencia.
- **MySQL Connector/J (mysql-connector-j:8.3.0)** – Conector JDBC para bases de datos MySQL.
- **Google Guava (guava:31.0.1-jre)** – Utilidades de colecciones y utilidades generales para Java.
- **JUnit Jupiter (junit-jupiter:5.8.2)** – Framework para pruebas unitarias.
- **Gradle** – Herramienta de construcción utilizada para gestionar dependencias y tareas.

## Otras consideraciones

- El proyecto está estructurado para soportar pruebas y cobertura de código mediante Jacoco.
- El archivo `build.gradle` centraliza todas las dependencias del sistema.
- Se recomienda el uso de GlassFish Server para ejecutar la aplicación y aprovechar la compatibilidad con Jakarta EE.
- El código está organizado siguiendo buenas prácticas de Java EE, como la inyección de dependencias y el uso de controladores para la vista.


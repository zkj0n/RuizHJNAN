# **Relación Uno a Muchos (Unidireccional Ordenada)**

Este proyecto implementa un CRUD completo para la entidad **Ciclo**, la cual mantiene una **relación uno a muchos unidireccional ordenada** con la entidad **Módulo**. Se utiliza **Hibernate con anotaciones** para la persistencia de datos.

## **Descripción**
Este sistema permite gestionar ciclos formativos y sus respectivos módulos de manera eficiente. Se utiliza Hibernate para mapear las relaciones en la base de datos, asegurando una correcta persistencia y organización de los datos. La aplicación incluye una interfaz web amigable que facilita la administración de los ciclos y sus módulos.

## **Tecnologías Utilizadas**
- **Java 11**: Lenguaje de programación utilizado en el backend.
- **Java EE 7**: Framework para aplicaciones empresariales con soporte para servlets y JSP.
- **JSP (JavaServer Pages)**: Para la generación de páginas dinámicas en el servidor.
- **CSS y Bootstrap**: Para una interfaz de usuario moderna y adaptable.
- **MySQL**: Sistema de gestión de bases de datos donde se almacenan las entidades.
- **Hibernate**: ORM que permite mapear las clases Java a la base de datos utilizando anotaciones.

---

## **Instalación**

### **Requisitos Previos**
1. **Java 11** instalado.
2. **MySQL** en ejecución.
3. **Servidor de aplicaciones** compatible con **Java EE 7** (por ejemplo, **Apache Tomcat** o **GlassFish**).
4. **IDE** como **IntelliJ IDEA**, **Eclipse** o **NetBeans**.

### **Pasos para ejecutar el proyecto**

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/zkj0n/RuizHJ1ANO.git
   ```

2. **Configurar la base de datos**:

   Crea una base de datos en MySQL con el siguiente comando:

   ```sql
   CREATE DATABASE hibernate CHARSET utf8 COLLATE utf8_spanish_ci;
   ```

3. **Configurar el servidor de aplicaciones**:

   Asegúrate de que **Tomcat** o **GlassFish** estén configurados correctamente para ejecutar aplicaciones **Java EE 7**.

4. **Ejecutar el proyecto**:

   Puedes ejecutarlo desde tu IDE o desplegar el archivo **WAR** en el servidor de aplicaciones.

5. **Acceder a la aplicación**:

   Una vez que el servidor esté corriendo, accede en tu navegador a:

   ```text
   http://localhost:8080/RuizHJ1ANO/
   ```

---

## **Características**
✅ **Relación uno a muchos unidireccional ordenada**: Un **Ciclo** puede tener varios **Módulos**, almacenados en orden específico.  
✅ **CRUD completo**: Permite crear, leer, actualizar y eliminar ciclos y sus módulos.  
✅ **Hibernate con anotaciones**: Configuración sin archivos XML.  
✅ **Interfaz amigable**: Basada en **Bootstrap** y **CSS**.  
✅ **Fácil de configurar**: Solo necesitas actualizar la base de datos en **MySQL**.

---

## **Licencia**
Este proyecto está bajo la licencia **MIT**.


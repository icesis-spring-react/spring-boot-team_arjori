# Taller 5: Spring Data.

## Taller 3: Spring Boot.

- La información de este taller se puede encontrar en el archivo README.OLD.md, por si se quiere revisar otra vez.

## Integrantes:

- Ricardo Medina Sterling.
- Jose Alejandro García Marcos.
- Ariel Eduardo Pabón Bolaños.

## Prerrequisitos:

- Usar IntelliJ preferiblemente.

## Adaptación del código a Spring Data:

- Primero se tiene que instanciar la base de datos PostgreSQL de forma local, para ello se siguen los siguientes pasos:

  1. Desde el usuario 'postgres' se debe ingresar a la línea de comandos con 'psql'.
  2. Ejecutar los siguientes comandos de SQL:

     1. **CREATE USER arjori WITH PASSWORD '12345';**
     2. **CREATE SCHEMA esquema_arjori AUTHORIZATION arjori;**
     3. **GRANT CREATE ON SCHEMA esquema_arjori TO arjori;**
     4. **GRANT USAGE, CREATE ON SCHEMA esquema_arjori TO arjori;**
     5. **GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA esquema_arjori TO arjori;**

  3. Asegurarse que la URL de la base de datos sea 'jdbc:postgresql://localhost:5432/postgres', el usuario sea 'arjori' y la contraseña sea '12345' en el 'pom.xml'.

- Los endpoints siguen siendo los mismos que los del Taller 3: Spring Boot, por lo que no necesita ninguna modificación.

## Probando los endpoints:

![BD](/docs/BD.png)

**Figura 1: Las tablas de la base de datos en PostgreSQL.**

![DIRECTORS](/docs/BD-DIR.png)

**Figura 2: Chequeo de que los datos sí se estén guardando en la tabla de DIRECTOR.**

![FILMS](/docs/BD-FILM.png)

**Figura 3: Chequeo de que los datos sí se estén guardando en la tabla de FILM.**
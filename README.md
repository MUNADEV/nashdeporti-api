# Nash Deporti: API

## Prerrequisitos

- [`Java 11`](https://www.oracle.com/java/technologies/downloads/#java11)
- [`Docker`](https://www.docker.com/)
- [`Docker-Compose`](https://docs.docker.com/compose/install/)


A continuación se detalla la intalación de nashdeporti-api

### Base de datos

Se instala la base de datos como contendedor de docker:

`sudo docker pull mongo`

### Arranque

En la carpeta donde se encuentra el proyecto ejecutaremos la imagen de la base de datos:


`sudo docker-compose up` 

Finalmente se debe lanzar el proyecto Springboot:

`mvn spring-boot:run`






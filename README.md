## Running services in Docker container

- In base package run this command from terminal:
````
    docker compose up -d
````
This will run Database, Product, User and Order services.

## Using API's from Swagger

- Open web browser and go api's swagger page

For User service:
``
localhost:8080/swagger-ui.html
``

For Product service:
``
localhost:8081/swagger-ui.html
``

For Order service:
``
localhost:8082/swagger-ui.html
``

# Super Cars Application

A Spring Boot application for managing luxury cars.

## Features
- Manage cars, owners, and dealers.
- RESTful API endpoints.
- Docker and Kubernetes support.

## Build and Run
```bash
mvn clean package
java -jar target/supercars-1.0.0.jar
```

## Docker
```bash
docker build -t supercars .
docker-compose up
```

## Kubernetes
Deploy using the manifests in the `k8s` folder.

FROM openjdk:22-jdk-slim
LABEL authors="peripheral"

WORKDIR /app

COPY target/inventory-service-0.0.1-SNAPSHOT.jar inventory_service.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/inventory_service.jar"]
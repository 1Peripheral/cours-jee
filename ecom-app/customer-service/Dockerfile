FROM openjdk:22-jdk-slim
LABEL authors="peripheral"

WORKDIR /app

COPY target/customer-service-0.0.1-SNAPSHOT.jar customer_service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/customer_service.jar"]
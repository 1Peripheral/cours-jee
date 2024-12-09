FROM openjdk:22-jdk-slim
LABEL authors="peripheral"

WORKDIR /app

COPY target/billing-service-0.0.1-SNAPSHOT.jar billing_service.jar

EXPOSE 8083


ENTRYPOINT ["java", "-jar", "/app/billing_service.jar"]
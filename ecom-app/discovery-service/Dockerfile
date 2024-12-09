FROM openjdk:22-jdk-slim
LABEL authors="peripheral"

WORKDIR /app

COPY target/discovery-service-0.0.1-SNAPSHOT.jar discovery_service.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app/discovery_service.jar"]
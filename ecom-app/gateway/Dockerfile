FROM openjdk:22-jdk-slim
LABEL authors="peripheral"

WORKDIR /app

COPY target/gateway-0.0.1-SNAPSHOT.jar gateway.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "/app/gateway.jar"]
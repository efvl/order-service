FROM eclipse-temurin:17-jdk-alpine

COPY order-server/target/*.jar order-service.jar
ENTRYPOINT ["java","-jar","/order-service.jar"]
EXPOSE 8080/tcp

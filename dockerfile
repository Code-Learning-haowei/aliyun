FROM openjdk:11-jdk-slim
COPY build/libs/number-check.jar /app/number-check.jar
WORKDIR /app
CMD ["java", "-jar", "number-check.jar"]

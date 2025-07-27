FROM gradle:8.8.0-jdk17 AS BUILD
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app/api-agendador.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/api-agendador.jar"]
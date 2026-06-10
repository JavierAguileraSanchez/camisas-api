FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY . /app

RUN chmod +x ./gradlew
RUN ./gradlew build -x test --no-daemon

EXPOSE 8080

CMD ["java", "-jar", "build/libs/camisas-api-0.0.1-SNAPSHOT.jar"]

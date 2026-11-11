# Etapa 1: build
FROM maven:3.9-eclipse-temurin-25 AS builder

WORKDIR /build

COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY src ./src
COPY lombok.config .

RUN mvn -B clean package -DskipTests

# Etapa 2: execucao
FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=builder /build/target/prova-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

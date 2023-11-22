FROM gradle:8-jdk17-alpine as build
WORKDIR /app

COPY gradle ./
COPY gradlew ./
COPY *.gradle.kts ./
COPY src src

RUN gradle bootJar

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY run.sh .
COPY --from=build /app/build/libs/lab4.jar ./app.jar

ENTRYPOINT ["./run.sh"]
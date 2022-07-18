FROM openjdk:11.0.15-jdk-bullseye

WORKDIR /app

COPY .mvn .mvn/
COPY mvnw pom.xml ./
RUN apt-get update && \
    apt-get install dos2unix && \
    apt-get clean
RUN dos2unix mvnw
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

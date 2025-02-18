FROM openjdk:25-oraclelinux9

WORKDIR /app

COPY target/car-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
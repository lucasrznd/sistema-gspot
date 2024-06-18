FROM openjdk:17-jdk

COPY target/educadora-gspot-0.0.1-SNAPSHOT.jar /app/gspot.jar

CMD ["java", "-jar", "/app/gspot.jar"]
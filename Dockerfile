FROM openjdk:21

EXPOSE 9091

WORKDIR /app

COPY /target/spring-boot-0.0.1-SNAPSHOT.jar /app/spring-boot-0.0.1-SNAPSHOT.jar

CMD ["java", "jar", "spring-boot-0.0.1-SNAPSHOT.jar"]
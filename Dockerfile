FROM openjdk:21

ENV APP_HOME=/app
ENV FR_POMPEY_CDA_WEBPROJET_URLAPI=http://apiprojet:9000

EXPOSE 9091

WORKDIR /app

COPY /target/spring-boot-0.0.1-SNAPSHOT.jar /app/spring-boot-0.0.1-SNAPSHOT.jar

CMD ["java", "jar", "spring-boot-0.0.1-SNAPSHOT.jar"]
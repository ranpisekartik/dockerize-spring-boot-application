#define base docker image
FROM openjdk:8
LABEL maintainer="learnwithkartik"
EXPOSE 8080 8000
ADD target/dockerizespringbootapplication-0.0.1-SNAPSHOT.jar dockerized-spring-boot-application.jar
ADD entrypoint.sh entrypoint.sh
#ENTRYPOINT ["java","-jar","dockerized-spring-boot-application.jar"]
ENTRYPOINT ["sh","entrypoint.sh"]
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/xp-management-0.0.1-SNAPSHOT.jar xp-management-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/xp-management-docker.jar"]
FROM openjdk:20
LABEL MAINTAINER="github.com/igorhenss"

COPY target/watchcat.jar watchcat.jar

ENTRYPOINT ["java", "-jar", "/watchcat.jar"]
EXPOSE 8080

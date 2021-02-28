#FROM openjdk:8-jre-alpine
#EXPOSE 8084
#WORKDIR /app
#COPY target/guessagender-0.0.1-SNAPSHOT.jar .
#ENTRYPOINT [ "java", "-jar", "guessagender-0.0.1-SNAPSHOT.jar" ]

#FROM openjdk:17-jdk-alpine3.12
#ADD target/guessagender-0.0.1-SNAPSHOT.jar .
#EXPOSE 8000
#CMD java -jar guessagender-0.0.1-SNAPSHOT.jar


FROM openjdk:17-jdk-alpine3.12
ADD target/guessagender-0.0.1-SNAPSHOT.jar .
EXPOSE 8089
CMD java -jar guessagender-0.0.1-SNAPSHOT.jar
FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 3000

ADD hopper.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

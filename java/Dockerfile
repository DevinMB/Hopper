FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 3000

ADD target/final-capstone-starter-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

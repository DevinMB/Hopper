FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 3000

ADD out/artifacts/final_capstone_starter_jar/final-capstone-starter.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

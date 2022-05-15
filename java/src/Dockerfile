FROM java:8

# RUN apt-get install -y --no-install-recommends software-properties-common
# RUN add-apt-repository -y ppa:openjdk-r/ppa
# RUN apt-get update
# RUN apt-get install -y openjdk-8-jdk
# RUN apt-get install -y openjdk-8-jre
# RUN update-alternatives --config java
# RUN update-alternatives --config javac

WORKDIR /app

ARG JAR_FILE=/out/artifacts/final_capstone_starter_jar/final-capstone-starter.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]







FROM adoptopenjdk/openjdk11:alpine-jre
RUN apk --no-cache add curl

# Refer to Maven build -> finalName
ARG JAR_FILE=target/hedera-*.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar -Dspring.profiles.active=prod app.jar
ENTRYPOINT ["java","-jar","app.jar", "--spring.profiles.active=postgres_docker"]

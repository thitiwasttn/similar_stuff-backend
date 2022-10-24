FROM eclipse-temurin:11.0.16_8-jre

RUN apt-get update && apt-get install nano

ENV TZ=Asia/Bangkok
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD target/*.jar /usr/src/app/entrypoint.jar

WORKDIR /usr/src/app/

ENV SECRET_DB_IP=127.0.0.1
ENV SECRET_DB_PORT=3306
ENV SECRET_DB_USERNAME=root
ENV SECRET_DB_PASSWORD=P@ssw0rd
ENV SECRET_SHOW_SQL=false
ENV SECRET_LOG=debug
ENV SECRET_LOG_LEVEL_SQL=info
ENTRYPOINT ["java","-jar", "/usr/src/app/entrypoint.jar"]
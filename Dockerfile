FROM openjdk:8
COPY /target/ApiTransacoes*.jar ApiTransacoes
WORKDIR /usr/src/api_transacoes
RUN javac Main.java

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar spring_boot_com_mysql.jar --spring.profiles.active=${PROFILE}
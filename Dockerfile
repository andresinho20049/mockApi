FROM openjdk:8
WORKDIR /usr/src/mockapi
COPY /target/mockapi*.jar mockapi.jar
COPY /mock/transacoes/*.json ./mock/transacoes/

SHELL ["/bin/sh", "-c"]

EXPOSE 8080
EXPOSE 5005

CMD java -jar mockapi.jar
FROM openjdk:11

ARG XMX=500m
ARG PROFILE=production

ENV XMX=$XMX
ENV PROFILE=$PROFILE

VOLUME /tmp

EXPOSE 8015

ADD ./target/curso_java-0.0.1-SNAPSHOT.jar curso_java.jar

ENTRYPOINT java -Xmx$XMX -jar /curso_java.jar --spring.profiles.active=$PROFILE
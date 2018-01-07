FROM openjdk:8-alpine

MAINTAINER sjyuan <sjyuan@thoughtworks.com>

COPY build/libs/*.jar /app/*.jar

WORKDIR /app

CMD java -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -verbose:gc -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationStoppedTime -Xloggc:gc_cdm.log -jar *.jar

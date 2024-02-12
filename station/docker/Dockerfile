FROM openjdk:17-oracle
COPY /target/station.jar module_station.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "module_station.jar"]
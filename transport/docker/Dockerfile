FROM openjdk:17-oracle
COPY /target/transport.jar module_transport.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "module_transport.jar"]
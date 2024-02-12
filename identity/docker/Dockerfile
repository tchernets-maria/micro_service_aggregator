FROM openjdk:17-oracle
COPY /target/identity.jar module_identity.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "module_identity.jar"]
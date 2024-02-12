FROM openjdk:17-oracle
COPY /target/client_api_route.jar module_client_api_route.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "module_client_api_route.jar"]
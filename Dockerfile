FROM openjdk:16.0.2
EXPOSE 1234
ADD /complete/target/contendo-service-j-docker.jar contendo-service-j-docker.jar
ENTRYPOINT ["java","-jar","/contendo-service-j-docker.jar"]
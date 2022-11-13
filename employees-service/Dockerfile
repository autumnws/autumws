#Start with a base image containing Java runtime
FROM openjdk:8-slim

#Information around who maintains the image
MAINTAINER autumn.com

# Add the application's jar to the container
COPY target/employees-service-0.0.1-SNAPSHOT.jar employees-service-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/employees-service-0.0.1-SNAPSHOT.jar"]
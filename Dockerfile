FROM amazoncorretto:11-alpine3.14

COPY target/DevopsSampleApplication-1.0.0.jar /var/lib/DevopsSampleApplication-1.0.0.jar

ENTRYPOINT ["java","-jar","var/lib/DevopsSampleApplication-1.0.0.jar"]

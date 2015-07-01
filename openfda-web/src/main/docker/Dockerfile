# Based on the Dockerfile from
#  https://github.com/spring-guides/gs-spring-boot-docker/blob/master/complete/src/main/docker/Dockerfile
# (Original is under Apache 2.0 license)

FROM java:8

# Spring boot uses /tmp
VOLUME /tmp

# Copy over the JAR file
ADD openfda-web-1.0-SNAPSHOT.jar openfda-web.jar

# Update timestamp for static content cache invalidation
RUN bash -c 'touch /openfda-web.jar'

# Run with /dev/urandom to reduce startup time.
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/openfda-web.jar"]
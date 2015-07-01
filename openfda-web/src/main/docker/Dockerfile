# Much of this was pulled from https://spring.io/guides/gs/spring-boot-docker/

FROM docker.io/centos

# Update packages and install JDK 8
RUN yum -y update && yum -y install java-1.8.0-openjdk-devel && yum clean all

# Spring boot uses /tmp
VOLUME /tmp

# Copy over the JAR file
ADD openfda-web-1.0-SNAPSHOT.jar app.jar

# Update timestamp for static content cache invalidation
RUN bash -c 'touch /app.jar'

# Run with /dev/urandom to reduce startup time.
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
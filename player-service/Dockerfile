FROM openjdk:8-jre-alpine

# define the argument required to build this docker file
ARG PROJECT_VERSION

# install bash to enable exec within kubernetes
RUN apk add --update --no-cache bash

# copy the player service jar with the correct version
COPY target/player-service-${PROJECT_VERSION}.jar /

# create a symlink from the copied jar to a well known name (${PROJECT_VERSION} in CMD is evaluated at run time!
RUN ln -s player-service-${PROJECT_VERSION}.jar player-service.jar

# add the entry point script
COPY entrypoint.sh /

# ensure it's executable
RUN chmod +x /entrypoint.sh

# expose the service port
EXPOSE 8080

# and run it on start up
CMD ["/bin/sh", "-c", "/entrypoint.sh"]
FROM openjdk:8-jre-alpine

# define the argument required to build this docker file
ARG PROJECT_VERSION

# install bash to enable exec within kubernetes
RUN apk add --update --no-cache bash

# copy the player service jar with the correct version
COPY target/broker-${PROJECT_VERSION}.jar /

# create a symlink from the copied jar to a well known name (${PROJECT_VERSION} in CMD is evaluated at run time!
RUN ln -s broker-${PROJECT_VERSION}.jar broker.jar

# add the entry point script
COPY entrypoint.sh /

# ensure it's executable
RUN chmod +x /entrypoint.sh

RUN cat /entrypoint.sh

# expose the uni-cast listener
EXPOSE 8090

# and run it on start up
CMD ["/bin/sh", "-c", "/entrypoint.sh"]
#FROM centos:7

#RUN yum install -y https://download.postgresql.org/pub/repos/yum/9.5/redhat/rhel-7-x86_64/pgdg-centos95-9.5-3.noarch.rpm


#RUN yum install -y \
#    postgresql95 \
#    postgresql95-server \
#    postgresql95-contrib \
#    less


FROM alpine:3.4

RUN apk add --update --no-cache bash

RUN apk add --update --no-cache \
    postgresql=9.5.12-r0 \
    postgresql-contrib=9.5.12-r0 \
    postgresql-client=9.5.12-r0 

ENV PGDATA /opt/pgsql/9.5/data/

ADD *.conf /
RUN chown postgres:postgres /*.conf

EXPOSE 5432

ADD entrypoint.sh /
RUN chmod 700 entrypoint.sh
RUN chown postgres:postgres entrypoint.sh

CMD ./entrypoint.sh

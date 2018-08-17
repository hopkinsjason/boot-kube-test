
#!/bin/sh


if [ ! -d $PGDATA/base ]; then

    mkdir -p $PGDATA
    chown -R postgres:postgres $PGDATA   
    
   su postgres -c 'initdb -D $PGDATA'

   sleep 5

   mv /*.conf $PGDATA
   chown -R postgres:postgres $PGDATA

   su postgres -c 'pg_ctl start -D $PGDATA'

   sleep 3
   
   psql -U postgres -c 'CREATE DATABASE regal;'
   psql -U postgres -c 'CREATE ROLE enterprisedb;'
   
   sleep 2

   su postgres -c 'pg_ctl stop -D $PGDATA'

fi



su postgres -c 'postgres -D $PGDATA'


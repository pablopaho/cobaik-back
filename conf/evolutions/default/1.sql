# --- !Ups

create table bikes (name VARCHAR NOT NULL PRIMARY KEY,reference VARCHAR NOT NULL);

# --- !Downs

drop table bikes;


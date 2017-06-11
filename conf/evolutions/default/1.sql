# --- !Ups

create table "bikes" ("id" SERIAL PRIMARY KEY,"name" VARCHAR NOT NULL,"reference" VARCHAR NOT NULL);

# --- !Downs

drop table "bikes";


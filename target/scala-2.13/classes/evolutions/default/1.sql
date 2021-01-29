# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table receta (
  id                            bigint auto_increment not null,
  nombre                        varchar(255),
  ingrediente                   varchar(255),
  tiempo_preparacion            integer not null,
  constraint pk_receta primary key (id)
);


# --- !Downs

drop table if exists receta;


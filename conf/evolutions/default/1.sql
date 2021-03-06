# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table descripcion (
  id                            bigint auto_increment not null,
  texto                         varchar(255),
  constraint pk_descripcion primary key (id)
);

create table ingrediente (
  id                            bigint auto_increment not null,
  nombre                        varchar(255),
  constraint pk_ingrediente primary key (id)
);

create table receta (
  id                            bigint auto_increment not null,
  nombre                        varchar(255),
  tiempo                        varchar(255),
  tipo                          varchar(255),
  descripcion_id                bigint,
  usuario_id                    bigint,
  constraint uq_receta_descripcion_id unique (descripcion_id),
  constraint pk_receta primary key (id)
);

create table receta_ingrediente (
  receta_id                     bigint not null,
  ingrediente_id                bigint not null,
  constraint pk_receta_ingrediente primary key (receta_id,ingrediente_id)
);

create table usuario (
  id                            bigint auto_increment not null,
  nombre                        varchar(255),
  constraint pk_usuario primary key (id)
);

alter table receta add constraint fk_receta_descripcion_id foreign key (descripcion_id) references descripcion (id) on delete restrict on update restrict;

create index ix_receta_usuario_id on receta (usuario_id);
alter table receta add constraint fk_receta_usuario_id foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;

create index ix_receta_ingrediente_receta on receta_ingrediente (receta_id);
alter table receta_ingrediente add constraint fk_receta_ingrediente_receta foreign key (receta_id) references receta (id) on delete restrict on update restrict;

create index ix_receta_ingrediente_ingrediente on receta_ingrediente (ingrediente_id);
alter table receta_ingrediente add constraint fk_receta_ingrediente_ingrediente foreign key (ingrediente_id) references ingrediente (id) on delete restrict on update restrict;


# --- !Downs

alter table receta drop constraint if exists fk_receta_descripcion_id;

alter table receta drop constraint if exists fk_receta_usuario_id;
drop index if exists ix_receta_usuario_id;

alter table receta_ingrediente drop constraint if exists fk_receta_ingrediente_receta;
drop index if exists ix_receta_ingrediente_receta;

alter table receta_ingrediente drop constraint if exists fk_receta_ingrediente_ingrediente;
drop index if exists ix_receta_ingrediente_ingrediente;

drop table if exists descripcion;

drop table if exists ingrediente;

drop table if exists receta;

drop table if exists receta_ingrediente;

drop table if exists usuario;


# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table campana (
  codigo                    varchar(255) not null,
  descripcion               varchar(255),
  familia                   varchar(255),
  proveedor                 varchar(255),
  constraint pk_campana primary key (codigo))
;

create table motivo (
  id                        bigint not null,
  resultado_id              bigint not null,
  codigo                    varchar(255),
  descripcion               varchar(255),
  constraint pk_motivo primary key (id))
;

create table resultado (
  id                        bigint not null,
  codigo                    varchar(255),
  descripcion               varchar(255),
  constraint pk_resultado primary key (id))
;

create table submotivo (
  id                        bigint not null,
  motivo_id                 bigint not null,
  codigo                    varchar(255),
  descripcion               varchar(255),
  residencial               boolean,
  negocios                  boolean,
  constraint pk_submotivo primary key (id))
;

create table user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (email))
;


create table campana_motivo (
  campana_codigo                 varchar(255) not null,
  motivo_id                      bigint not null,
  constraint pk_campana_motivo primary key (campana_codigo, motivo_id))
;
create sequence campana_seq;

create sequence motivo_seq;

create sequence resultado_seq;

create sequence submotivo_seq;

create sequence user_seq;

alter table motivo add constraint fk_motivo_resultado_1 foreign key (resultado_id) references resultado (id) on delete restrict on update restrict;
create index ix_motivo_resultado_1 on motivo (resultado_id);
alter table submotivo add constraint fk_submotivo_motivo_2 foreign key (motivo_id) references motivo (id) on delete restrict on update restrict;
create index ix_submotivo_motivo_2 on submotivo (motivo_id);



alter table campana_motivo add constraint fk_campana_motivo_campana_01 foreign key (campana_codigo) references campana (codigo) on delete restrict on update restrict;

alter table campana_motivo add constraint fk_campana_motivo_motivo_02 foreign key (motivo_id) references motivo (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists campana;

drop table if exists campana_motivo;

drop table if exists motivo;

drop table if exists resultado;

drop table if exists submotivo;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists campana_seq;

drop sequence if exists motivo_seq;

drop sequence if exists resultado_seq;

drop sequence if exists submotivo_seq;

drop sequence if exists user_seq;


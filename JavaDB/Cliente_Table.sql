﻿CREATE TABLE "Prova_Cliente"(
  "ID" integer NOT NULL,
  "Matricula" integer,
  "Nome" character varying(256),
  ONSTRAINT "Prova_Cliente_pkey" PRIMARY KEY ("ID" )
)
WITH (
  OIDS=FALSE
);

ALTER TABLE "Prova_Cliente"  WNER O "Escola";

CREATE SEQUENCE cliente_seq;
CREATE DATABASE MUSICA;

USE MUSICA;


CREATE TABLE AUTOR (
IDAUTOR INT PRIMARY KEY  AUTO_INCREMENT,
NOME VARCHAR(40),
IDADE INT);

CREATE TABLE PAIS (
IDPAIS INT PRIMARY KEY AUTO_INCREMENT,
NOME VARCHAR(40),
CONTINENTE VARCHAR(40),
IDIOMA VARCHAR(40));

CREATE TABLE BANDA (
IDBANDA INT PRIMARY KEY AUTO_INCREMENT,
NOME VARCHAR(40),
DATA_DE_CRIAÇÃO VARCHAR(10));

CREATE TABLE GENERO (
IDGENERO INT PRIMARY KEY AUTO_INCREMENT,
NOME VARCHAR(40),
SUBGENERO VARCHAR(40));

CREATE TABLE MUSICAS (
IDMUSICAS INT PRIMARY KEY AUTO_INCREMENT,
FK_AUTOR INT,
FK_PAIS INT,
FK_BANDA INT,
FK_GENERO INT);

ALTER TABLE PAIS
RENAME COLUMN NOME TO PAIS;

ALTER TABLE BANDA 
RENAME COLUMN NOME TO BANDA;

ALTER TABLE GENERO
RENAME COLUMN NOME TO GENERO;

INSERT INTO AUTOR (NOME, IDADE) VALUES
("ZÉ",25),
("LUKE",19),
("ANA",32),
("LIZA",21),
("CARLA",29);

ALTER TABLE MUSICAS
ADD COLUMN NOME_MUSICA VARCHAR(40);

INSERT INTO PAIS (PAIS, CONTINENTE, IDIOMA) VALUES
("BRASIL","AMERICA DO SUL","PORTUGUES"),
("EUA","AMERICA DO NORTE", "INGLES"),
("JAPÃO","ASIA","JAPONES"),
("EGITO","AFRICA","ARABE"),
("ALEMANHA","EUROPA","ALEMÃO");

INSERT INTO BANDA (BANDA, DATA_DE_CRIAÇÃO) VALUES
("APOCALIPSE",1999),
("RATOS CANSADOS",1985),
("MUCOUS MEMBRANE", 1975),
("कुत्ते से सावधान",2001),
("TIKOLOHO SEHLOHO",2019);

INSERT INTO GENERO (GENERO, SUBGENERO) VALUES
("ROCK","DEATH METAL"),
("POP","PINK POP"),
("ROCK","PUNK ROCK"),
("FUNK","FUNK PROIBIDAO"),
("MUSICA CLASSICA","CLASSIC");

SELECT * FROM MUSICAS;

INSERT INTO MUSICAS (NOME_MUSICA) VALUES
("TEMPESTADE EM COPO DAGUA"),
("MINOXIDIL"),
("ODEIO PC DA POSITIVO"),
("A HISTÓRIA DE UM CASTOR"),
("A VIDA É UM INFERNO");

ALTER TABLE MUSICAS
ADD FOREIGN KEY (FK_AUTOR) REFERENCES AUTOR(IDAUTOR),
ADD FOREIGN KEY (FK_PAIS) REFERENCES PAIS(IDPAIS),
ADD FOREIGN KEY (FK_BANDA) REFERENCES BANDA(IDBANDA),
ADD FOREIGN KEY (FK_GENERO) REFERENCES GENERO(IDGENERO);

DESC MUSICAS;

UPDATE MUSICAS
SET FK_AUTOR = 1, FK_PAIS = 1, FK_BANDA = 1, FK_GENERO = 1
WHERE IDMUSICAS = 1;

UPDATE MUSICAS
SET FK_AUTOR = 2, FK_PAIS = 2, FK_BANDA = 2, FK_GENERO = 2
WHERE IDMUSICAS = 2;

UPDATE MUSICAS
SET FK_AUTOR = 3, FK_PAIS = 3, FK_BANDA = 3, FK_GENERO = 3
WHERE IDMUSICAS = 3;

UPDATE MUSICAS
SET FK_AUTOR = 4, FK_PAIS = 4, FK_BANDA = 4, FK_GENERO = 4
WHERE IDMUSICAS = 4;

UPDATE MUSICAS
SET FK_AUTOR = 5, FK_PAIS = 5, FK_BANDA = 5, FK_GENERO = 5
WHERE IDMUSICAS = 5;

SELECT * FROM MUSICAS;

SELECT NOME AS "ARTISTA", NOME_MUSICA AS "NOME DA MÚSICA", BANDA, GENERO
FROM BANDA
INNER JOIN MUSICAS
ON BANDA.IDBANDA = MUSICAS.FK_BANDA
INNER JOIN GENERO
ON GENERO.IDGENERO = MUSICAS.FK_GENERO
INNER JOIN AUTOR
ON AUTOR.IDAUTOR = MUSICAS.FK_AUTOR;



/*
Escrito por Donilo Jordão - feito no terminal porque não tenho workbench - 
RA: 01212008
*/


mysql> show databases;

mysql> CREATE DATABASE JOGOS;

mysql> USE JOGOS;

mysql> CREATE TABLE TABELA_TIME (
    -> IDTIME INT PRIMARY KEY AUTO_INCREMENT,
    -> NOME_TIME VARCHAR(45),
    -> DATA_FUNDAÇÃO_TIME DATE,
    -> RANKEAMENTO CHAR(1) CHECK( RANKEAMENTO = "D" OR RANKEAMENTO = "C" OR RANKEAMENTO = "B" OR RANKEAMENTO = "A" OR RANKEAMENTO = "S"),
    -> VALOR_TIME DECIMAL(11,2));


mysql> CREATE TABLE JOGADORES (
    -> IDJOGADORES INT PRIMARY KEY AUTO_INCREMENT,
    -> NOME_JOGADORES VARCHAR(50),
    -> NASCIMENTO_JOGADORES DATE,
    -> SEXO_JOGADORES CHAR(1) CHECK(SEXO = "M" OR SEXO = "F"),
    -> PASSE_JOGADOR DECIMAL(10,2),
    -> FK_TIME INT,
    -> FOREIGN KEY(FK_TIME) REFERENCES TABELA_TIME(IDTIME));


mysql> CREATE TABLE SEGUIDORES (
    -> IDSEGUIDORES INT PRIMARY KEY AUTO_INCREMENT,
    -> NOME_SEGUIDOR VARCHAR(50),
    -> DATA_FOLLOW DATE,
    -> SEXO_SEGUIDOR CHAR(1) CHECK(SEXO_SEGUIDOR = "M" OR SEXO_SEGUIDOR = "F"),
    -> VALOR_CARTEIRINHA DECIMAL(6,2),
    -> FK_JOGADOR INT,
    -> FOREIGN KEY(FK_JOGADOR) REFERENCES JOGADORES(IDJOGADORES));


mysql> SHOW TABLES;
+-----------------+
| Tables_in_JOGOS |
+-----------------+
| JOGADORES       |
| SEGUIDORES      |
| TABELA_TIME     |
+-----------------+


mysql> DESC TABELA_TIME;
+----------------------+---------------+------+-----+---------+----------------+
| Field                | Type          | Null | Key | Default | Extra          |
+----------------------+---------------+------+-----+---------+----------------+
| IDTIME               | int(11)       | NO   | PRI | NULL    | auto_increment |
| NOME_TIME            | varchar(45)   | YES  |     | NULL    |                |
| DATA_FUNDAÇÃO_TIME   | date          | YES  |     | NULL    |                |
| RANKEAMENTO          | char(1)       | YES  |     | NULL    |                |
| VALOR_TIME           | decimal(10,2) | YES  |     | NULL    |                |
+----------------------+---------------+------+-----+---------+----------------+


mysql> INSERT INTO TABELA_TIME (NOME_TIME, DATA_FUNDAÇÃO_TIME, RANKEAMENTO, VALOR_TIME)
    -> VALUES
    -> ("ATLETICO","1980-12-25","C",25000.00),
    -> ("JUVENTUDE","1999-05-18","A",74500.00),
    -> ("CAÇAROLA","2005-02-04","S",7000000.00);


mysql> SELECT * FROM TABELA_TIME;
+--------+-----------+----------------------+-------------+------------+
| IDTIME | NOME_TIME | DATA_FUNDAÇÃO_TIME   | RANKEAMENTO | VALOR_TIME |
+--------+-----------+----------------------+-------------+------------+
|      1 | ATLETICO  | 1980-12-25           | C           |   25000.00 |
|      2 | JUVENTUDE | 1999-05-18           | A           |   74500.00 |
|      3 | CAÇAROLA  | 2005-02-04           | S           | 7000000.00 |
+--------+-----------+----------------------+-------------+------------+


mysql> DESC JOGADORES;
+----------------------+---------------+------+-----+---------+----------------+
| Field                | Type          | Null | Key | Default | Extra          |
+----------------------+---------------+------+-----+---------+----------------+
| IDJOGADORES          | int(11)       | NO   | PRI | NULL    | auto_increment |
| NOME_JOGADORES       | varchar(50)   | YES  |     | NULL    |                |
| NASCIMENTO_JOGADORES | date          | YES  |     | NULL    |                |
| SEXO_JOGADORES       | char(1)       | YES  |     | NULL    |                |
| PASSE_JOGADOR        | decimal(10,2) | YES  |     | NULL    |                |
| FK_TIME              | int(11)       | YES  | MUL | NULL    |                |
+----------------------+---------------+------+-----+---------+----------------+


mysql> INSERT INTO JOGADORES (NOME_JOGADORES,NASCIMENTO_JOGADORES,SEXO_JOGADORES,PASSE_JOGADOR,FK_TIME)
    -> VALUES
    -> ("MARCIO","1988-04-03","M",1300.00,1),
    -> ("CAMPBELL","1997-11-06","M",250000.50,3),
    -> ("LYANNA","2004-07-13","F",102500.00,2),
    -> ("CLARA","2000-01-25","F",50000.00,1),
    -> ("JULIUS","1975-04-30","M",44900.00,3);


mysql> DESC SEGUIDORES;
+-------------------+--------------+------+-----+---------+----------------+
| Field             | Type         | Null | Key | Default | Extra          |
+-------------------+--------------+------+-----+---------+----------------+
| IDSEGUIDORES      | int(11)      | NO   | PRI | NULL    | auto_increment |
| NOME_SEGUIDOR     | varchar(50)  | YES  |     | NULL    |                |
| DATA_FOLLOW       | date         | YES  |     | NULL    |                |
| SEXO_SEGUIDOR     | char(1)      | YES  |     | NULL    |                |
| VALOR_CARTEIRINHA | decimal(6,2) | YES  |     | NULL    |                |
| FK_JOGADOR        | int(11)      | YES  | MUL | NULL    |                |
+-------------------+--------------+------+-----+---------+----------------+


mysql> INSERT INTO SEGUIDORES
    -> (NOME_SEGUIDOR, DATA_FOLLOW, SEXO_SEGUIDOR, VALOR_CARTEIRINHA, FK_JOGADOR)
    -> VALUES
    -> ("JOAO","2010-05-04","M",500.00,3),
    -> ("LIZA","2013-02-20","F",85.50,1),
    -> ("STEBAN","2007-10-15","M",410.99,2),
    -> ("BEATRIZ","2011-05-05","F",100.00,2),
    -> ("GABRIEL","1999-12-12","M",8000.00,3);

mysql> DESC TABELA_TIME;
+----------------------+---------------+------+-----+---------+----------------+
| Field                | Type          | Null | Key | Default | Extra          |
+----------------------+---------------+------+-----+---------+----------------+
| IDTIME               | int(11)       | NO   | PRI | NULL    | auto_increment |
| NOME_TIME            | varchar(45)   | YES  |     | NULL    |                |
| DATA_FUNDAÇÃO_TIME   | date          | YES  |     | NULL    |                |
| RANKEAMENTO          | char(1)       | YES  |     | NULL    |                |
| VALOR_TIME           | decimal(10,2) | YES  |     | NULL    |                |
+----------------------+---------------+------+-----+---------+----------------+


mysql> UPDATE TABELA_TIME
    -> SET NOME_TIME = "CARVALHO"
    -> WHERE IDTIME = 2;

mysql> SELECT * FROM TABELA_TIME;
+--------+-----------+----------------------+-------------+------------+
| IDTIME | NOME_TIME | DATA_FUNDAÇÃO_TIME   | RANKEAMENTO | VALOR_TIME |
+--------+-----------+----------------------+-------------+------------+
|      1 | ATLETICO  | 1980-12-25           | C           |   25000.00 |
|      2 | CARVALHO  | 1999-05-18           | A           |   74500.00 |
|      3 | CAÇAROLA  | 2005-02-04           | S           | 7000000.00 |
+--------+-----------+----------------------+-------------+------------+

mysql> DESC JOGADORES;
+----------------------+---------------+------+-----+---------+----------------+
| Field                | Type          | Null | Key | Default | Extra          |
+----------------------+---------------+------+-----+---------+----------------+
| IDJOGADORES          | int(11)       | NO   | PRI | NULL    | auto_increment |
| NOME_JOGADORES       | varchar(50)   | YES  |     | NULL    |                |
| NASCIMENTO_JOGADORES | date          | YES  |     | NULL    |                |
| SEXO_JOGADORES       | char(1)       | YES  |     | NULL    |                |
| PASSE_JOGADOR        | decimal(10,2) | YES  |     | NULL    |                |
| FK_TIME              | int(11)       | YES  | MUL | NULL    |                |
+----------------------+---------------+------+-----+---------+----------------+

mysql> UPDATE JOGADORES
    -> SET NOME_JOGADORES = "MIRANDA"
    -> WHERE IDJOGADORES = 1;


mysql> SELECT SUM(PASSE_JOGADOR) FROM JOGADORES;
+--------------------+
| SUM(PASSE_JOGADOR) |
+--------------------+
|          448700.50 |
+--------------------+


mysql> SELECT AVG(VALOR_TIME) AS "MEDIA DOS TIMES" FROM TABELA_TIME;
+-----------------+
| MEDIA DOS TIMES |
+-----------------+
|  2366500.000000 |
+-----------------+


mysql> DESC SEGUIDORES;
+-------------------+--------------+------+-----+---------+----------------+
| Field             | Type         | Null | Key | Default | Extra          |
+-------------------+--------------+------+-----+---------+----------------+
| IDSEGUIDORES      | int(11)      | NO   | PRI | NULL    | auto_increment |
| NOME_SEGUIDOR     | varchar(50)  | YES  |     | NULL    |                |
| DATA_FOLLOW       | date         | YES  |     | NULL    |                |
| SEXO_SEGUIDOR     | char(1)      | YES  |     | NULL    |                |
| VALOR_CARTEIRINHA | decimal(6,2) | YES  |     | NULL    |                |
| FK_JOGADOR        | int(11)      | YES  | MUL | NULL    |                |
+-------------------+--------------+------+-----+---------+----------------+


mysql> SELECT * FROM SEGUIDORES
    -> LEFT JOIN JOGADORES
    -> ON SEGUIDORES.FK_JOGADOR = JOGADORES.IDJOGADORES;
+--------------+---------------+-------------+---------------+-------------------+------------+-------------+----------------+----------------------+----------------+---------------+---------+
| IDSEGUIDORES | NOME_SEGUIDOR | DATA_FOLLOW | SEXO_SEGUIDOR | VALOR_CARTEIRINHA | FK_JOGADOR | IDJOGADORES | NOME_JOGADORES | NASCIMENTO_JOGADORES | SEXO_JOGADORES | PASSE_JOGADOR | FK_TIME |
+--------------+---------------+-------------+---------------+-------------------+------------+-------------+----------------+----------------------+----------------+---------------+---------+
|            6 | JOAO          | 2010-05-04  | M             |            500.00 |          3 |           3 | LYANNA         | 2004-07-13           | F              |     102500.00 |       2 |
|            7 | LIZA          | 2013-02-20  | F             |             85.50 |          1 |           1 | MIRANDA        | 1988-04-03           | M              |       1300.00 |       1 |
|            8 | STEBAN        | 2007-10-15  | M             |            410.99 |          2 |           2 | CAMPBELL       | 1997-11-06           | M              |     250000.50 |       3 |
|            9 | BEATRIZ       | 2011-05-05  | F             |            100.00 |          2 |           2 | CAMPBELL       | 1997-11-06           | M              |     250000.50 |       3 |
|           10 | GABRIEL       | 1999-12-12  | M             |           8000.00 |          3 |           3 | LYANNA         | 2004-07-13           | F              |     102500.00 |       2 |
+--------------+---------------+-------------+---------------+-------------------+------------+-------------+----------------+----------------------+----------------+---------------+---------+


mysql> SELECT * FROM TABELA_TIME
    -> LEFT JOIN JOGADORES
    -> ON JOGADORES.FK_TIME = TABELA_TIME.IDTIME
    -> WHERE JOGADORES.SEXO_JOGADORES = "M";
+--------+-----------+----------------------+-------------+------------+-------------+----------------+----------------------+----------------+---------------+---------+
| IDTIME | NOME_TIME | DATA_FUNDAÇÃO_TIME   | RANKEAMENTO | VALOR_TIME | IDJOGADORES | NOME_JOGADORES | NASCIMENTO_JOGADORES | SEXO_JOGADORES | PASSE_JOGADOR | FK_TIME |
+--------+-----------+----------------------+-------------+------------+-------------+----------------+----------------------+----------------+---------------+---------+
|      1 | ATLETICO  | 1980-12-25           | C           |   25000.00 |           1 | MIRANDA        | 1988-04-03           | M              |       1300.00 |       1 |
|      3 | CAÇAROLA  | 2005-02-04           | S           | 7000000.00 |           2 | CAMPBELL       | 1997-11-06           | M              |     250000.50 |       3 |
|      3 | CAÇAROLA  | 2005-02-04           | S           | 7000000.00 |           5 | JULIUS         | 1975-04-30           | M              |      44900.00 |       3 |
+--------+-----------+----------------------+-------------+------------+-------------+----------------+----------------------+----------------+---------------+---------+


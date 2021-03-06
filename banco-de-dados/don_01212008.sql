CREATE DATABASE FACULDADE;

USE FACULDADE;

CREATE TABLE GRUPO (
IDGRUPO INT PRIMARY KEY AUTO_INCREMENT,
NOMEGRUPO VARCHAR(40),
DESCRICAO VARCHAR(100)
);

CREATE TABLE PROFESSOR (
IDPROFESSOR INT PRIMARY KEY AUTO_INCREMENT,
PROFESSOR VARCHAR (40) NOT NULL,
DISCIPLINA VARCHAR(50)
)AUTO_INCREMENT = 1000;

CREATE TABLE ALUNO (
RA CHAR(8) PRIMARY KEY,
ALUNO VARCHAR(40) NOT NULL,
EMAIL CHAR(100) NOT NULL,
FK_GRUPO INT,
FOREIGN KEY (FK_GRUPO) REFERENCES GRUPO (IDGRUPO)
);

CREATE TABLE GRUPOPROFESSOR (
HORARIO DATETIME,
NOTA DECIMAL(3,2),
FK_PROFESSOR INT,
FK_GRUPO INT,
PRIMARY KEY (FK_GRUPO, FK_PROFESSOR, HORARIO),
FOREIGN KEY (FK_PROFESSOR) REFERENCES PROFESSOR (IDPROFESSOR),
FOREIGN KEY (FK_GRUPO) REFERENCES GRUPO (IDGRUPO)
);

-- 2 INSERINDO DADOS

INSERT INTO GRUPO (NOMEGRUPO, DESCRICAO) 
VALUE ("CLUBE DA LUTA", "VOCE NAO FALA SOBRE O CLUBE DA LUTA"),
      ("HUNTERXHUNTER", "SOBRE SE TORNAR UM CAÇADOR");
      
INSERT INTO PROFESSOR (PROFESSOR, DISCIPLINA)
VALUE ("TYLER DURDEN", "BRIGA DE RUA"),
	  ("ISSAC NETERO", "CONTROLE DO NEN");
      
INSERT INTO ALUNO (RA, ALUNO, EMAIL, FK_GRUPO)
VALUE ("05543213", "JACK", "JACK@FACULDADE.COM.BR", 1),
      ("09983812", "MARLA", "MARLA@FACULDADE.COM.BR", 1),
      ("07321013", "ROBERT", "ROBERT@FACULDADE.COM.BR", 1),
      ("02847193", "GON", "GON@FACULDADE.COM.BR", 2),
      ("06297126", "KILLUA", "KILLUA@FACULDADE.COM.BR", 2),
      ("05233313", "LEORIO", "LEORIO@FACULDADE.COM.BR", 2);

INSERT INTO GRUPOPROFESSOR (HORARIO, NOTA, FK_PROFESSOR, FK_GRUPO)
VALUE ('2021-11-11 15:40:00', '9.00', 1000, 1),
      ('2021-11-12 12:15:00', '7.50', 1001, 1),
      ('2021-11-13 16:45:00', '9.50', 1000, 2),
      ('2021-11-14 09:30:00', '5.50', 1001, 2);
      
-- 3 EXIBINDO AS TABELA
      
SELECT * FROM GRUPO;

SELECT * FROM PROFESSOR;

SELECT * FROM  ALUNO;

SELECT * FROM GRUPOPROFESSOR;

-- 5 DADOS DO GRUPO, E ALUNO

SELECT * FROM GRUPO JOIN ALUNO ON FK_GRUPO = IDGRUPO;

-- 6 DADO DE UM DETERMINADO GRUPO, E ALUNO

SELECT * FROM GRUPO JOIN ALUNO ON FK_GRUPO = IDGRUPO
					WHERE IDGRUPO = 1;
                    
-- 7 EXIBIR MEDIA DAS NOTAS

SELECT AVG(NOTA) AS MEDIA_NOTA FROM GRUPOPROFESSOR;

-- 8 NOTA MINIMA

SELECT MIN(NOTA) AS MINIMO_NOTA, MAX(NOTA) AS MAXIMO_NOTA FROM GRUPOPROFESSOR;

-- 9 SOMA TOTAL DAS NOTAS

SELECT SUM(NOTA) AS SOMA_NOTA FROM GRUPOPROFESSOR;

-- 10 DADOS PROFESSORES QUE AVALIA UM DETERMINADO GRUPO, E O DADO DO GRUPO

SELECT GRUPOPROFESSOR.HORARIO, GRUPOPROFESSOR.NOTA, PROFESSOR.*, GRUPO.* FROM GRUPOPROFESSOR 
                                         JOIN PROFESSOR ON FK_PROFESSOR = IDPROFESSOR
                                         JOIN GRUPO ON FK_GRUPO = IDGRUPO;
                                         
-- 11 DADO DE PROFESSOR QUE AVALIA UM DETERMINADO GRUPO, DADO DO GRUPO E HORARIO DA AVALIACÃO

SELECT PROFESSOR.*, GRUPO.*, GRUPOPROFESSOR.HORARIO FROM GRUPOPROFESSOR
										 JOIN PROFESSOR ON FK_PROFESSOR = IDPROFESSOR
                                         JOIN GRUPO ON FK_GRUPO = IDGRUPO
                                         WHERE IDGRUPO = 1;
                                         
-- 12 EXIBIR O NOMES DO GRUPO, QUE FOI AVALIADO POR UM DETERMINADO PROFESSOR


-- 13 EXIBIR OS DADOS DOS GRUPO, OS DADOS DOS ALUNOS OS DADOS DOS PROFESSORES

-- 14 EXIBIR A QUATIDADE DE NOTA

SELECT DISTINCT COUNT(NOTA) AS QTD_NOTA FROM GRUPOPROFESSOR;

-- 15 IDENTIFICAÇÃO DO PROFESSOR, MEDIA DAS NOTAS E SOMA DA NOTAS ATRIBUIDAS, AGRUPADA POR PROFESSORES

SELECT PROFESSOR, AVG(NOTA), SUM(NOTA) FROM PROFESSOR JOIN GRUPOPROFESSOR ON FK_PROFESSOR = IDPROFESSOR GROUP BY PROFESSOR;

-- 16 IDENTIFICAÇÃO DO GRUPO MEDIA DAS NOTAS E SOMA DA NOTAS ATRIBUIDAS, AGRUPADA POR GRUPO

SELECT NOMEGRUPO, AVG(NOTA), SUM(NOTA) FROM GRUPO JOIN GRUPOPROFESSOR ON FK_GRUPO = IDGRUPO GROUP BY NOMEGRUPO;

-- 17 EXIIR A IDENTIFICAÇÃO DO PROFESSOR, E A MENOR NOTA E A MAIOR NOTA

SELECT PROFESSOR, MIN(NOTA), MAX(NOTA) FROM PROFESSOR JOIN GRUPOPROFESSOR ON FK_PROFESSOR = IDPROFESSOR GROUP BY PROFESSOR;

-- 18 EXIIR A IDENTIFICAÇÃO DO GRUPO, E A MENOR NOTA E A MAIOR NOTA

SELECT NOMEGRUPO, MIN(NOTA), MAX(NOTA) FROM GRUPO JOIN GRUPOPROFESSOR ON FK_GRUPO = IDGRUPO GROUP BY NOMEGRUPO;
create database  Busfacility;
use Busfacility;

CREATE TABLE Empresa (
    idEmpresa INT PRIMARY KEY AUTO_INCREMENT,
    nomeEmpresa VARCHAR(50),
    representante VARCHAR(50),
    cnpj VARCHAR(50),
    email VARCHAR(100),
    endereco VARCHAR(100),
    telefoneEmpresa VARCHAR(20),
    senha VARCHAR(45),
    permissaoEmpresa int
);

CREATE TABLE usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nomeUsuario VARCHAR(50),
    senhaUsuario VARCHAR(45),
    permissaoUsuario int,
    fkEmpresa int,
	foreign key (fkEmpresa) references empresa(idEmpresa)
)  AUTO_INCREMENT = 2000;

create table onibus (
idOnibus int primary key auto_increment,
nomeLinha varchar(45),
placa varchar(10),
fkEmpresa int,
foreign key (fkEmpresa) references empresa(idEmpresa)
);

create table sensor (
idSensor int primary key auto_increment,
nSerie varchar(45),
posicao varchar(45),
fkOnibus int,
foreign key (fkOnibus) references onibus(idOnibus)
);

create table registro (
idRegistro int primary key auto_increment,
dataHora datetime,
contagem int,
fkSensor int,
foreign key (fkSensor) references sensor(idSensor)
);

 -- insert into Registro (dataHora, contagem, fkSensor)
-- values 
-- ('2021-09-04 15:40:03', 26, 301),
-- ('2021-09-05 23:09:03', 19, 302),
-- ('2021-09-06 21:15:23', 14, 303),
-- ('2021-09-24 14:35:24', 28, 304);

select * from empresa;
select * from usuario;

INSERT INTO usuario (nomeUsuario, senha, permissao)
VALUES
('teste');

CREATE TABLE Onibus (
    idOnibus INT PRIMARY KEY AUTO_INCREMENT,
    chassi VARCHAR(30),
    placa VARCHAR(10),
    fkEmpresa INT,
    FOREIGN KEY (fkEmpresa)
        REFERENCES Empresa (idEmpresa)
) AUTO_INCREMENT = 201;

CREATE TABLE Sensor (
    idSensor INT PRIMARY KEY AUTO_INCREMENT,
    n_Serie VARCHAR(30),
    posicao VARCHAR(30),
    fkOnibus INT,
    FOREIGN KEY (fkOnibus)
        REFERENCES Onibus (idOnibus)
) AUTO_INCREMENT = 301;

CREATE TABLE Registro (
    idRegistro INT PRIMARY KEY AUTO_INCREMENT,
    dataHora DATETIME DEFAULT CURRENT_TIMESTAMP,
    contagem INT,
    fkSensor INT,
    FOREIGN KEY (fkSensor)
        REFERENCES Sensor (idSensor)
) AUTO_INCREMENT = 501;6

insert into Empresa (nomeEmpresa, representante, cnpj, email, endereco, telefoneEmpresa, senha)
values 
('Johnson', 'Neymar', '13. 222. 333/0001-44.', 'Johnson@neymar.com', 'R. Afonso silva, 138', '2641-2641', '12345667'),
('Pfzier', 'Douglas', '22. 111. 333/0001-12.', 'pfizer@pfizer.com.br', 'R. Imparato, 23', '2645-2289', '21231214'),
('HP', 'Harry', '33. 444. 111/0001-13.', 'HP@gmail.com', 'R. dos Alfeneiros, 138', '2246-7080', '12345678'),
('Via4', 'João', '35. 465. 666/0001-17.', 'via4@via4.com', 'Av. Paulista, 987', '2283-9623', 'VIA4SENHA');

SELECT * FROM Empresa;


SELECT * FROM Onibus;
select * from sensor;

-- insert into Sensor (nSerie, posicao, fkOnibus)
-- values 
-- ('4535', 'assento da frente 3', 201),
-- ('3545', 'corredor fundo', 202),
-- ('7654', 'assento do fundo 1', 203),
-- ('1345', 'assento do fundo 3', 204);

SELECT * FROM Sensor;



insert into Onibus (nomeLinha, placa, fkEmpresa)
values 
('9B2N3D34F', 'DER-1324', 1),
('A2D3D4G4', 'BTE-9090', 2),
('S2F3G5H6', 'SEF-1242', 3),
('G6H4J8K5', 'ZDF-1528', 4);

select * from onibus;

SELECT * FROM Registro;




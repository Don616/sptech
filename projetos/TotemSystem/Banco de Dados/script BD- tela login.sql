CREATE DATABASE totemsystem;

use totemsystem;

CREATE TABLE IF NOT EXISTS Usuario(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(255),
email VARCHAR(255),
senha VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS tb_totem(
idtotem INT PRIMARY KEY AUTO_INCREMENT,
sistemaOperacional varchar(45)
);

INSERT INTO Usuario VALUES (null, 'admin', 'admin@admin.com', '12345678');
INSERT INTO Usuario VALUES (null, 'don', 'don@admin.com', '12345678');


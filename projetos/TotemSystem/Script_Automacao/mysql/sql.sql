CREATE DATABASE totemsystem;

-- drop database totemsystem;

use totemsystem;

create table tb_empresa(
id_empresa int primary key AUTO_INCREMENT,
cnpj varchar(45),
razao_social varchar(45),
rua_empresa varchar(45),
numero_empresa varchar(45),
complemento_empresa varchar(45),
telefone_empresa varchar(45),
email_empresa varchar(45),
senha_empresa varchar(45));

create table tb_estacao(
id_estacao int PRIMARY KEY AUTO_INCREMENT,
fk_empresa int,
nome_estacao varchar(45),
linha_estacao varchar(45),
bairro_estacao varchar(45),
latitude_estacao varchar(45),
longitude_estacao varchar(45),
FOREIGN KEY(fk_empresa) REFERENCES tb_empresa(id_empresa));

create table tb_usuario(
id_usuario int primary key AUTO_INCREMENT,
fk_empresa int,
nome varchar(45),
cpf varchar(45),
cargo varchar(45),
email varchar(45),
senha varchar(45),
telefone varchar(45),
FOREIGN KEY(fk_empresa) REFERENCES tb_empresa(id_empresa));

create table tb_totem(
hostname varchar(45) primary key,
fk_estacao int,
data_implementacao varchar(45),
modelo varchar(45),
marca varchar(45),
data_fabricacao varchar(45),
sistema_operacional varchar(45),
fabricante_sistema varchar(45),
arquitetura int,
inicializado_em varchar(45),
permissoes varchar(45),
marca_processador varchar(45),
fabricante_processador varchar(45),
micro_arquitetura varchar(45),
cpus_fisicas bigint,
cpus_logicas bigint,
pacotes_fisicos int,
frequencia bigint,
data_atual varchar(45),
FOREIGN KEY(fk_estacao) REFERENCES tb_estacao(id_estacao));

create table tb_log(
id_log int primary key AUTO_INCREMENT,
fk_hostname varchar(45),
memoria_uso bigint,
memoria_disponivel bigint,
total_processos int,
total_threads int,
total_servicos int,
total_servicos_ativos int,
total_servicos_inativos int,
volume_total bigint,
volume_disponivel bigint,
volume_em_uso bigint,
data_atual varchar(45),
FOREIGN KEY(fk_hostname) REFERENCES tb_totem(hostname));

create table tb_manutencao_totem(
id_manutencao_totem int primary key AUTO_INCREMENT,
fk_usuario int,
fk_hostname varchar(45),
data_manutencao varchar(45),
descricao_manutencao varchar(255),
FOREIGN KEY(fk_usuario) REFERENCES tb_usuario(id_usuario),
FOREIGN KEY(fk_hostname) REFERENCES tb_totem(hostname));

insert into tb_empresa (razao_social, email_empresa, senha_empresa) values
("Empresa Teste LTDA","teste@teste.com","12345678");

insert into tb_usuario (fk_empresa,nome,email,senha) values
(1,"Don","don@email.com","12345678");

insert into tb_usuario (fk_empresa,nome,email,senha) values
(1,"adm",'adm@adm.com',"12345678");

insert into tb_estacao(fk_empresa, nome_estacao) values
(1,"Liberdade"),
(1,"Consolacao"),
(1,"Paulista");

--insert into tb_totem(fk_estacao,hostname) values
--(2,"VERINBK000062");


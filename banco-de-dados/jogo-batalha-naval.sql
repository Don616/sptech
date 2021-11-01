/*
Escolher um jogo;
Criar entre 3 ~ 5 tabelas;
Elas precisam se relacionar em si;
Será contabilizado como tabela também tabelas associativas;
Busquem usar relacionamento forte, fraco, um pra n, zero pra 1 etc etc. Máximo possível;
Declarem as regras do jogo;
Jogo escolhido: Batalha Naval;
Tabelas:
 - Jogador1 = {
	IdJogador1;
    Nome;
    
 };


 - Tabuleiro = {
	
 };
 - Peças = {
 
	Porta-Aviões = 5;
    Navios-Tanque = 4;
    Contra-Torpedos = 3;
    Submarinos = 2;
    Minas-Marítimas = 1;
    
 };
 
 
*/

CREATE DATABASE BATALHA_NAVAL;

USE BATALHA_NAVAL;

CREATE TABLE JOGADOR (
ID_JOGADOR INT PRIMARY KEY AUTO_INCREMENT,
NOME_JOGADOR VARCHAR(45),
PONTOS_JOGADOR INT,
TIROS_JOGADOR INT);



var database = require("../database/config");

function obterPassageiros(user) {
    instrucaoSql = `SELECT Entrada, Saida FROM MEDIDA;`;
    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function quantidadeDado(user) {
    instrucaoSql = `SELECT (SELECT COUNT(fk_aquario) AS QT FROM MEDIDA WHERE fk_aquario = 1) AS 'quantidade';`;
    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

var database = require("../database/config")

function addColaborador(nome, senha, permissao) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", nome, senha, permissao);
    var instrucao = `
    INSERT INTO usuario (nomeUsuario, senha, permissao) VALUES
    ('${nome}', md5('${senha}', ${permissao});
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function entrar(email, senha) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", email, senha)
    var instrucao = `
        SELECT * FROM empresa WHERE email = '${email}' AND senha = md5('${senha}';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    addColaborador,
    obterPassageiros,
    quantidadeDado
};

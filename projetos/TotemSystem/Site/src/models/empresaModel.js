const { func } = require("assert-plus");
var database = require("../database/config");

function listar() {
  var instrucao = `
  SELECT * FROM tb_empresa
  `;
  console.log("Listando Usuários");
  return database.executar(instrucao);
}


function cadastrar(cnpj, email, senha) {
  console.log("ACESSEI O EMPRESA MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", cnpj, email, senha);
  var instrucao = `
      INSERT INTO tb_empresa (cnpj, email_empresa, senha_empresa) VALUES ('${cnpj}', '${email}', '${senha}');
  `;
  console.log("Executando a instrução SQL: \n" + instrucao);
  return database.executar(instrucao);
}

function entrar(email, senha) {
  console.log("ACESSEI O EMPRESA MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", email, senha)
  var instrucao = `
      SELECT * FROM tb_empresa WHERE email_empresa = '${email}' AND senha_empresa = '${senha}';
  `;
  console.log("Executando a instrução SQL: \n" + instrucao);
  return database.executar(instrucao);
}

function atualizar(id, razaoSocial, ruaEmpresa, numeroEmpresa, complementoEmpresa, telefoneEmpresa){
  var instrucao = `
    UPDATE tb_empresa 
    SET razao_social = '${razaoSocial}', rua_empresa = '${ruaEmpresa}', numero_empresa = '${numeroEmpresa}', complemento_empresa = '${complementoEmpresa}', telefone_empresa = '${telefoneEmpresa}'
    WHERE id_empresa = ${id};
  `;
  return database.executar(instrucao);
}

function deletar(id){
  
  var instrucao = `
    DELETE FROM tb_empresa WHERE id_empresa = ${id}
  `
  return database.executar(instrucao)
}


module.exports = {
  listar,
  cadastrar,
  entrar,
  atualizar,
  deletar
};

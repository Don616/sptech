var database = require("../database/config");


function cadastrarColaborador(fkEmpresa, nome, cpf, cargo, senha, telefone, email){
    var instrucao = `
      INSERT INTO tb_usuario (fk_empresa, nome, cpf, cargo, senha, telefone, email) VALUES (${fkEmpresa}, '${nome}', '${cpf}', '${cargo}', '${senha}', '${telefone}', '${email}')
    `;
  
    return database.executar(instrucao)
  }
  
  function atualizarColaborador(nome, cpf, cargo, senha, telefone, email){
    var instrucao = `
      UPDATE tb_usuario  SET nome = '${nome}', cpf = '${cpf}', cargo = '${cargo}', senha = '${senha}', telefone = '${telefone}', email = '${email}' WHERE CPF = '${cpf}')
    `;
  
    return database.executar(instrucao)
  }
  
  
  
  function deletarColaborador(cpf){
    var instrucao = `
      DELETE FROM tb_usuario WHERE CPF = ${cpf} 
    `;
  
    return database.executar(instrucao)
  }
module.exports = {
    cadastrarColaborador,
    deletarColaborador,
    atualizarColaborador
}  
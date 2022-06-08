var database = require("../database/config");

function cadastrarTotem(
  hostname,
  nomeEstacao,
  dataImplementacao,
  modelo,
  marca,
  dataFabricacao
) {
  var instrucao = `
      INSERT INTO tb_totem (hostname, fk_estacao, data_implementacao, modelo, marca,data_fabricacao) VALUES ( '${hostname}', (SELECT id_estacao FROM tb_estacao WHERE nome_estacao = '${nomeEstacao}'), '${dataImplementacao}', '${modelo}', '${marca}','${dataFabricacao}')
    `;

  return database.executar(instrucao);
}

function atualizarTotem(hostname, nomeEstacao) {
  var instrucao = `
      UPDATE tb_totem SET fk_estacao = (SELECT id_estacao FROM tb_estacao WHERE nome_estacao = '${nomeEstacao}') WHERE hostname = '${hostname}' 
    `;

  return database.executar(instrucao);
}

function deletarTotem(hostname) {
  var instrucao = `
      DELETE FROM tb_totem WHERE hostname = '${hostname}' 
    `;

  return database.executar(instrucao);
}

function getTotemLog(hostname) {
  var instrucao = `
    SELECT TOP 100 tt.hostname, tl.id_log, tl.memoria_uso, tl.memoria_disponivel, tl.total_processos, tl.total_threads, tl.total_servicos,
    tl.total_servicos_ativos, tl.total_servicos_inativos, tl.volume_total, tl.volume_disponivel, tl.volume_em_uso, tl.data_atual  FROM [dbo].[tb_totem] tt
    JOIN [dbo].[tb_log] tl 
    ON tt.hostname = '${hostname}'
    `;
    return database.executar(instrucao);
}

module.exports = {
  cadastrarTotem,
  deletarTotem,
  atualizarTotem,
  getTotemLog
};

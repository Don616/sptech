const res = require('express/lib/response');
var estacaoModel = require('../models/estacaoModel')

function dadosTotens(req, res) {
  estacaoModel.dadosTotensMem(req.body.hostname)
    .then(function (resultado) {
      estacaoModel.dadosTotensVol(req.body.hostname)
        .then(function (resultadoCpu) {
          estacaoModel.dadosTotensServicos(req.body.hostname)
            .then(function (resultadoServico) {
              estacaoModel.dadosTotensProcessos(req.body.hostname)
                .then(function (resultadoProcesso) {
                  if (resultado.length > 0) {
                    res.status(200).json({ memoria: resultado, volume: resultadoCpu, servicos: resultadoServico, processos: resultadoProcesso });
                  } else {
                    res.status(204).send("Nenhum resultado encontrado!");
                  }
                })
            })
        })
    }).catch(function (erro) {
      console.log(erro);
      console.log(
        "Houve um erro ao realizar a consulta! Erro: ",
        erro.sqlMessage
      );
      res.status(500).json(erro.sqlMessage);
    });

}

function totensPorEmpresa(req, res) {
  estacaoModel.totensPorEmpresa(req.body.idEmpresa, req.body.estacaoNome)
    .then(function (resultado) {
      if (resultado.length > 0) {
        res.status(200).json(resultado);
      } else {
        res.status(204).send("Nenhum resultado encontrado!");
      }
    }).catch(function (erro) {
      console.log(erro);
      console.log(
        "Houve um erro ao realizar a consulta! Erro: ",
        erro.sqlMessage
      );
      res.status(500).json(erro.sqlMessage);
    });
}

function estacoesPorEmpresa(req, res) {
  estacaoModel.estacoesPorEmpresa(req.params.idEmpresa).then(function (resultado) {
    if (resultado.length > 0) {
      res.status(200).json(resultado);
    } else {
      res.status(204).send("Nenhum resultado encontrado!");
    }
  }).catch(function (erro) {
    console.log(erro);
    console.log(
      "Houve um erro ao realizar a consulta! Erro: ",
      erro.sqlMessage
    );
    res.status(500).json(erro.sqlMessage);
  });
}


function cadastrarEstacao(req, res) {
  var nome = req.body.nomeServer;
  var linha = req.body.linhaServer;
  var bairro = req.body.bairroServer;
  var cep = req.body.cepServer;
  var fkEmpresa = req.params.fkEmpresa;


  if (nome == undefined) {
    res.status(400).send("Seu nome está undefined!");
  } else if (linha == undefined) {
    res.status(400).send("Sua linha está undefined!");
  } else if (bairro == undefined) {
    res.status(400).send("Seu bairro está undefined!");
  } else if (cep == undefined) {
    res.status(400).send("Seu cep está undefinied")
  }

  estacaoModel.cadastrarEstacao(fkEmpresa, nome, linha, bairro, cep)
    .then(
      function (resultado) {
        res.json(resultado);
      }
    ).catch(
      function (erro) {
        console.log(erro);
        console.log(
          "\nHouve um erro ao realizar o cadastro! Erro: ",
          erro.sqlMessage
        );
        res.status(500).json(erro.sqlMessage);
      }
    );

}

function atualizarEstacao(req, res) {
  console.log("atualizar", req.body);
  var nomeEstacao = req.body.nomeServer;
  var linhaEstacao = req.body.linhaServer;
  var bairroEstacao = req.body.bairroServer;
  var cepEstacao = req.body.cepServer;
  var idEstacao = req.params.idEstacao;

  if (nomeEstacao == "") {
    res.status(400).send("Nome não está definida!");
  } else if (linhaEstacao == "") {
    res.status(400).send("Linha não definido!");
  } else if (bairroEstacao == "") {
    res.status(400).send("Bairro não definido!");
  } else if (cepEstacao == "") {
    res.status(400).send("CEP não definido!");
  } else {
    estacaoModel
      .atualizarEstacao(
        idEstacao,
        nomeEstacao,
        linhaEstacao,
        bairroEstacao,
        cepEstacao,
      )
      .then(function (resultado) {
        res.status(200).json(req.body);
        res.json(resultado);
      })
      .catch(function (erro) {
        console.log(erro);
        console.log(
          "\nHouve um erro ao realizar a edição! Erro: ",
          erro.sqlMessage
        );
        res.status(500).json(erro.sqlMessage);
      });
  }
}

function deletarEstacao(req, res){
  estacaoModel.deletarEstacao(req.params.idEstacao)
  .then(
    function (resultado){
      res.json(resultado);
    }
  ).catch(
    function (erro) {
      console.log(erro)
      console.log(
        "\n Houve erro ao realizar a exclusao! Erro: ",
        erro.sqlMessage
      );
      res.status(500).json(erro.sqlMessage);
    }
  );
}


module.exports = { dadosTotens, totensPorEmpresa, estacoesPorEmpresa, cadastrarEstacao, atualizarEstacao, deletarEstacao }
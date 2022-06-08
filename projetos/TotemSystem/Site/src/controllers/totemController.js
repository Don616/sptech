var totemModel = require("../models/totemModel");

function cadastrarTotem(req, res) {
  var hostname = req.body.hostnameServer;
  var modelo = req.body.modeloServer;
  var marca = req.body.marcaServer;
  var dataImplementacao = req.body.dataImplementacaoServer;
  var dataFabricacao = req.body.dataFabricacaoServer;
  var nomeEstacao = req.body.nomeEstacaoServer;

  if (modelo == undefined) {
    res.status(400).send("Seu modelo está undefined!");
  } else if (marca == undefined) {
    res.status(400).send("Sua marca está undefined!");
  } else if (dataImplementacao == undefined) {
    res.status(400).send("Sua data de implementacao está undefined!");
  } else if (dataFabricacao == undefined) {
    res.status(400).send("Sua data de fabricacao está undefinied");
  } else if (hostname == undefined) {
    res.status(400).send("Seu hostname está undefinied");
  }
  totemModel
    .cadastrarTotem(hostname, nomeEstacao, modelo, marca,dataImplementacao, dataFabricacao)
    .then(function (resultado) {
      res.json(resultado);
    })
    .catch(function (erro) {
      console.log(erro);
      console.log(
        "\nHouve um erro ao realizar o cadastro do totem! Erro: ",
        erro.sqlMessage
      );
      res.status(500).json(erro.sqlMessage);
    });

}

function atualizarTotem(req, res) {
  var hostname = req.params.hostname;
  var nomeEstacao = req.body.nomeEstacaoServer;

  if (nomeEstacao == undefined) {
    res.status(400).send("O nome da sua estacao está undefined!");
  }

  totemModel
    .atualizarTotem(hostname, nomeEstacao)
    .then(function (resultado) {
      res.json(resultado);
    })
    .catch(function (erro) {
      console.log(erro);
      console.log(
        "\nHouve um erro ao atualizar o totem! Erro: ",
        erro.sqlMessage
      );
      res.status(500).json(erro.sqlMessage);
    });
}

function deletarTotem(req, res) {
  var hostname = req.params.hostname;
  totemModel
    .deletarTotem(hostname)
    .then(function (resultado) {
      res.json(resultado);
    })
    .catch(function (erro) {
      console.log(erro);
      console.log(
        "\nHouve um erro ao deletar o totem! Erro: ",
        erro.sqlMessage
      );
      res.status(500).json(erro.sqlMessage);
    });
}

function getTotemLog(req, res) {
  var hostname = req.params.hostname;
  totemModel
    .getTotemLog(hostname)
    .then(function (resultado) {
      if (resultado.length > 0) {
        res.status(200).json(resultado);
      } else {
        res.status(204).send("Nenhum resultado encontrado!");
      }
    })
    .catch(function (erro) {
      console.log(erro);
      console.log(
        "Houve um erro ao realizar a consulta! Erro: ",
        erro.sqlMessage
      );
      res.status(500).json(erro.sqlMessage);
    });
}

module.exports = {
  cadastrarTotem,
  atualizarTotem,
  deletarTotem,
  getTotemLog
};

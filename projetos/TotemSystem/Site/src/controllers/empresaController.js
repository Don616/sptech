const { json } = require("express/lib/response");
var empresaModel = require("../models/empresaModel");

function testar(req, res) {
  console.log("ENTRAMOS NA empresaController");
  res.json("ESTAMOS FUNCIONANDO!");
}

function listar(req, res) {
  empresaModel
    .listar()
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

function cadastrar(req, res) {
  var cnpj = req.body.cnpjServer;
  var email = req.body.emailServer;
  var senha = req.body.senhaServer;

  if (cnpj == undefined) {
    res.status(400).send("Seu cnpj está undefined!");
  } else if (email == undefined) {
    res.status(400).send("Seu email está undefined!");
  } else if (senha == undefined) {
    res.status(400).send("Sua senha está undefined!");
  }

  empresaModel
    .cadastrar(cnpj, email, senha)
    .then(function (resultado) {
      res.json(resultado);
    })
    .catch(function (erro) {
      console.log(erro);
      console.log(
        "\nHouve um erro ao realizar o cadastro! Erro: ",
        erro.sqlMessage
      );
      res.status(500).json(erro.sqlMessage);
    });
}
function entrar(req, res) {
  var email = req.body.emailServer;
  var senha = req.body.senhaServer;

  if (email == undefined) {
    res.status(400).send("Seu email está undefined!");
  } else if (senha == undefined) {
    res.status(400).send("Sua senha está indefinida!");
  } else {
    empresaModel
      .entrar(email, senha)
      .then(function (resultado) {
        console.log(`\nResultados encontrados: ${resultado.length}`);
        console.log(`Resultados: ${JSON.stringify(resultado)}`); // transforma JSON em String

        if (resultado.length == 1) {
          console.log(resultado);
          res.json(resultado[0]);
        } else if (resultado.length == 0) {
          res.status(403).send("Email e/ou senha inválido(s)");
        } else {
          res.status(403).send("Mais de um usuário com o mesmo login e senha!");
        }
      })
      .catch(function (erro) {
        console.log(erro);
        console.log(
          "\nHouve um erro ao realizar o login! Erro: ",
          erro.sqlMessage
        );
        res.status(500).json(erro.sqlMessage);
      });
  }
}

function atualizar(req, res) {
  console.log("atualizar", req.body);
  var razaoSocial = req.body.razaoSocialServer;
  var ruaEmpresa = req.body.ruaServer;
  var numeroEmpresa = req.body.numeroServer;
  var complementoEmpresa = req.body.complementoServer;
  var telefoneEmpresa = req.body.telefoneServer;
  var id = req.params.id;

  if (razaoSocial == "") {
    res.status(400).send("Razao social não está definida!");
  } else if (ruaEmpresa == "") {
    res.status(400).send("Rua não definido!");
  } else if (numeroEmpresa == "") {
    res.status(400).send("Numero não definido!");
  } else if (complementoEmpresa == "") {
    res.status(400).send("Complemento não definido!");
  } else if (telefoneEmpresa == "") {
    res.status(400).send("Telefone não definido!");
  } else {
    empresaModel
      .atualizar(
        id,
        razaoSocial,
        ruaEmpresa,
        numeroEmpresa,
        complementoEmpresa,
        telefoneEmpresa
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

function deletar(req, res){
  empresaModel.deletar(req.params.id)
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

module.exports = {
  listar,
  testar,
  cadastrar,
  entrar,
  atualizar,
  deletar
};

var colaboradorModel = require("../models/colaboradorModel");


    function cadastrarColaborador(req, res){
        var nome = req.body.nomeServer;
        var cpf = req.body.cpfServer;
        var cargo = req.body.cargoServer;
        var telefone = req.body.telefoneServer;
        var email = req.body.emailServer;
        var senha = req.body.senhaServer;
        var fkEmpresa = req.params.fkEmpresa
  
        if (nome == undefined) {
          res.status(400).send("Seu nome está undefined!");
      } else if (cpf == undefined) {
          res.status(400).send("Seu cpf está undefined!");
      } else if (cargo == undefined) {
          res.status(400).send("Seu cargo está undefined!");
      } else if (telefone == undefined){
        res.status(400).send("Seu telefone está undefinied")
      } else if (email == undefined){
        res.status(400).send("Seu email está undefinied")
      } else if (senha == undefined){
        res.status(400).send("Sua senha está undefinied")
      }
          
          colaboradorModel.cadastrarColaborador(fkEmpresa, nome, cpf, cargo, telefone, email, senha)
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
  // aqui
      function atualizarColaborador(req, res){
        var nome = req.body.nomeServer;
        var cpf = req.body.params;
        var cargo = req.body.cargoServer;
        var telefone = req.body.telefoneServer;
        var email = req.body.emailServer;
        var senha = req.body.senhaServer;
  
        if (nome == undefined) {
          res.status(400).send("Seu nome está undefined!");
      } else if (cpf == undefined) {
          res.status(400).send("Seu cpf está undefined!");
      } else if (cargo == undefined) {
          res.status(400).send("Seu cargo está undefined!");
      } else if (telefone == undefined){
        res.status(400).send("Seu telefone está undefinied")
      } else if (email == undefined){
        res.status(400).send("Seu email está undefinied")
      } else if (senha == undefined){
        res.status(400).send("Sua senha está undefinied")
      }
          
          colaboradorModel.atualizarColaborador(nome, cpf, cargo, telefone, email, senha)
              .then(
                  function (resultado) {
                      res.json(resultado);
                  }
              ).catch(
                  function (erro) {
                      console.log(erro);
                      console.log(
                          "\nHouve um erro para atualizar o cadastro! Erro: ",
                          erro.sqlMessage
                      );
                      res.status(500).json(erro.sqlMessage);
                  }
              );
  
      }
  // aqui
  function deletarColaborador(req,res){    
    var cpf = req.params.cpf;
    colaboradorModel.deletarColaborador(cpf)
             .then(
                 function (resultado) {
                     res.json(resultado);
                 }
             ).catch(
                 function (erro) {
                     console.log(erro);
                     console.log(
                         "\nHouve um erro ao deletar colaborador! Erro: ",
                         erro.sqlMessage
                     );
                     res.status(500).json(erro.sqlMessage);
                 }
             )
   }
  
   
module.exports = {
    deletarColaborador,
    atualizarColaborador,
    cadastrarColaborador,
}
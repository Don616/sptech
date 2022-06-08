var express = require("express");
var router = express.Router();

var estacaoController = require("../controllers/estacaoController")

router.post("/dados-totens", function (req, res) {
  estacaoController.dadosTotens(req, res);
});

router.post("/totens-por-estacao", function (req, res) {
  estacaoController.totensPorEmpresa(req, res);
});

router.get("/estacoes-por-empresa/:idEmpresa", function (req, res) {
  estacaoController.estacoesPorEmpresa(req, res);
});

router.get("/estacoes-por-empresa-batata/:idEmpresa", function (req, res) {
  estacaoController.estacoesPorEmpresaBatata(req, res);
});

router.post("/cadastrarEstacao/:fkEmpresa", function(req, res){
  estacaoController.cadastrarEstacao(req,res);
})

router.put("/atualizarEstacao/:idEstacao", function(req, res){
  estacaoController.atualizarEstacao(req,res);
})

router.delete("/deletarEstacao/:idEstacao", function(req, res){
  estacaoController.deletarEstacao(req,res);
})



module.exports = router
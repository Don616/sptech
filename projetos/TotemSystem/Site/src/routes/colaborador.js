var express = require("express");
var router = express.Router();

var colaboradorController = require("../controllers/colaboradorController")

router.post("/cadastrarColaborador/:fkEmpresa", function(req, res){
    colaboradorController.cadastrarColaborador(req,res);
  })
  
  router.put("/atualizarColaborador", function(req, res){
    colaboradorController.atualizarColaborador(req,res);
  })

  
module.exports = router;
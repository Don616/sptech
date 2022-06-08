var express = require("express");
var router = express.Router();

var totemController = require("../controllers/totemController")


router.post("/cadastrarTotem", function(req, res){
    totemController.cadastrarTotem(req,res);
  })
  

  router.put("/atualizarTotem/:hostname", function(req, res) {
    totemController.atualizarTotem(req, res);
  })
  
  router.delete("/deletarTotem/:hostname", function(req, res) {
    totemController.deletarTotem(req, res);
  })

  router.get("/getTotemLog/:hostname", function(req, res){
    totemController.getTotemLog(req,res);
  })

  module.exports = router;
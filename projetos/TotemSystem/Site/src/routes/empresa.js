var express = require("express");
const { route } = require("express/lib/application");
var router = express.Router();

var empresaController = require("../controllers/empresaController");

router.get("/", function (req, res) {
  empresaController.testar(req, res);
});

router.get("/listar", function (req, res) {
  empresaController.listar(req, res);
});

router.post("/cadastrar", function (req, res) {
  empresaController.cadastrar(req, res);
})

router.put("/atualizar/:id", function(req, res) {
  empresaController.atualizar(req, res);
})

router.delete("/deletar/:id" ,function(req, res){
  empresaController.deletar(req, res);
})

router.post("/autenticar", function (req, res) {
  empresaController.entrar(req, res);
});

module.exports = router;

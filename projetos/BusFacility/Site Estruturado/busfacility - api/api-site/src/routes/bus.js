var express = require("express");
var router = express.Router();

var busController = require("../controllers/busController");

router.get("/obterpassageiros/:user", function (req, res) {
    busController.obterPassageiros(req, res);
});

router.get("/quantidadedado/:user", function (req, res) {
    busController.quantidadeDado(req, res);
});


router.post("/addColaborador", function (req, res) {
    busController.addColaborador(req, res);
});

module.exports = router;
var busModel = require("../models/busModel");

function obterPassageiros(req, res) {

    var user = req.params.user;
    
    busModel.obterPassageiros(user).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

function quantidadeDado(req, res) {

    var user = req.params.user;
    
    busModel.quantidadeDado(user).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}


var sessoes = [];

function addColaborador(req, res) {
    var nome = req.body.nomeServer;
    var senha = req.body.senhaServer;
    var permissao = req.body.permissaoServer;


    if (nome == undefined) {
        res.status(400).send("Seu nome está undefined!");
    } else {
        
        busModel.addColaborador(nome, senha, permissao)
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
}

module.exports = {
    obterPassageiros,
    addColaborador,
    quantidadeDado,
}
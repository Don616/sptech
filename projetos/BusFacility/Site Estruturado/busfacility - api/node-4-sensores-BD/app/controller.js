const express = require('express');
const { ArduinoData } = require('./serial')
const router = express.Router();
const db = require('./connection');

router.get('/temperature', (request, response, next) => {

    let sum = ArduinoData.ListTemp.reduce((a, b) => a + b, 0);
    let average = (sum / ArduinoData.ListTemp.length).toFixed(2);

    response.json({
        data: ArduinoData.ListTemp,
        total: ArduinoData.ListTemp.length,
        average: isNaN(average) ? 0 : average
    });

});

router.get('/humidity', (request, response, next) => {

    let sum = ArduinoData.List.reduce((a, b) => a + b, 0);
    let average = (sum / ArduinoData.List.length).toFixed(2);

    response.json({
        data: ArduinoData.List,
        total: ArduinoData.List.length,
        average: isNaN(average) ? 0 : average
    });

});

router.get('/chave',(request, response, next) => {
    let sum = ArduinoData.ListSwitch.reduce((a,b) => a + b,0);
    let average = (sum / ArduinoData.ListSwitch.length).toFixed();

    response.json({
        data: ArduinoData.ListSwitch,
        total: ArduinoData.ListSwitch.length,
        average: isNaN(average) ? 0 : average
    });
});

router.get('/lux',(request, response, next) => {
    let sum = ArduinoData.ListLux.reduce((a,b) => a + b,0);
    let average = (sum / ArduinoData.ListLux.length).toFixed(2);

    response.json({
        data: ArduinoData.ListLux,
        total: ArduinoData.ListLux.length,
        average: isNaN(average) ? 0 : average
    });
});


router.post('/sendData', (request, response) => {
    let temperatura = ArduinoData.ListTemp[ArduinoData.ListTemp.length - 1];
    let umidade = ArduinoData.List[ArduinoData.List.length - 1];
    let pessoas = ArduinoData.ListSwitch[ArduinoData.ListSwitch.length - 1];
    let lux = ArduinoData.ListLux[ArduinoData.ListLux.length - 1];

    /**
     * Para inserir apenas temperatura utilize o bloco abaixo
     */
    var sql = "INSERT INTO medida(temp) VALUES(?)"; 
    let values = [temperatura];

    /**
     * Para inserir todos os valores utilize o bloco abaixo
     * 
     * var sql = "Insert INTO medida(temp,umi,pessoas,lux) VALUES(?)";
     * let values = [temperatura,umidade,pessoas,lux]
     */
    db.query(sql, [values], function(err, result){
        if(err) throw err;
        console.log("Medidas inseridas: " + result.affectedRows)
    });
    response.sendStatus(200);
});

module.exports = router;
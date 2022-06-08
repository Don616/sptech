const express = require('express');
const { ArduinoData } = require('./serial')
const router = express.Router();
const db = require('./connection');

router.get('/temperature', (request, response, next) => {

    let sum = ArduinoData.ListSaiu.reduce((a, b) => a + b, 0);
    let average = (sum / ArduinoData.ListSaiu.length).toFixed(2);

    response.json({
        data: ArduinoData.ListSaiu,
        total: ArduinoData.ListSaiu.length,
        average: isNaN(average) ? 0 : average,
    });

});


router.get('/humidity', (request, response, next) => {

    let sum = ArduinoData.ListEntrou.reduce((a, b) => a + b, 0);
    let average = (sum / ArduinoData.ListEntrou.length).toFixed(2);

    response.json({
        data: ArduinoData.ListEntrou,
        total: ArduinoData.ListEntrou.length,
        average: isNaN(average) ? 0 : average,
    });

});


router.post('/sendData', (request, response) => {
    entrada = Number(Math.random() * 20 + 1);
    saida = Number(Math.random() * 15 - 1);

    let data_agora = new Date()

    var sql = "INSERT INTO medida(entrada, saida, momento, fkOnibus) VALUES(?)";
    values = [entrada, saida, data_agora, 1];
    db.query(sql, [values], function(err, result){
        if(err) throw err;
        console.log("Medidas inseridas: " + result.affectedRows)
    });
    response.sendStatus(200);
})

module.exports = router;
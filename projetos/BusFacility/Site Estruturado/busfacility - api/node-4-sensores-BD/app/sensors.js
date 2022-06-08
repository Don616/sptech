function lm35(min, max) {
    min = typeof min == "undefined" ? 18 : min;
    max = typeof max == "undefined" ? 25 : max;
  
    let random = Math.random() * (max - min) + min;
  
    return random;
};


function tcrt5000() {
    min = 0;
    max = 1;
  
    let random = Math.random() * (max - min) + min;
  
    if (random > 0.5) {
      return 1;
    } else if (random <= 0.5) {
      return 0;
    }
};

/**
 * Neste bloco crio uma função de soma e em seguida
 * uma função pessoas que simula a soma de pessoas a cada 10 min = 60 blocos de 10s
 */

const soma = (x,y) => x + y;

function pessoas(){
  let a = [];
  for(let i = 0; i < 60; i++){
    let medida = tcrt5000();
    a.push(medida)
  }
  let sum = a.reduce(soma);
  return sum;
}

function ldr() {
    //let min = 0;
    let min = 560;
    let max = 1023;
    let valor_ADC = 0.00488758;
    let r_ohms = 10000;
    let vin = 5.00;
  
    let ldr_read = Math.floor(Math.random() * (max - min + 1) + min);
    let vout = ldr_read * valor_ADC;
    let res_ldr = (r_ohms * (vin - vout))/vout;
    let lux = 500/(res_ldr/1000);
  
    return lux;
};
  
function dht11(options) {
    minHumidity = options.minHum;
    maxHumidity = options.maxHum;
  
    minTemperature = options.minTemp;
    maxTemperature = options.maxTemp;
  
    if (minHumidity < 20 || maxHumidity > 100) {
      throw new Error(
        "Os valores minímos e máximos para umidade são 20% e 100% respectivamente."
      );
    }
  
    if (minTemperature < 0 || maxTemperature > 50) {
      throw new Error(
        "Os valores minímos e máximos para temperatura são 0 e 50 respectivamente."
      );
    }
  
    minTemperature = typeof minTemperature == "undefined" ? 18 : minTemperature;
    maxTemperature = typeof maxTemperature == "undefined" ? 25 : maxTemperature;
  
    minHumidity = typeof minHumidity == "undefined" ? 20 : minHumidity;
    maxHumidity = typeof maxHumidity == "undefined" ? 80 : maxHumidity;
  
    let randomHumidity = Math.floor(
      Math.random() * (maxHumidity - minHumidity + 1) + minHumidity
    );
  
    let randomTemperature =
      Math.random() * (maxTemperature - minTemperature) + minTemperature;
  
    return [randomHumidity, randomTemperature];
  }
  

  console.log(pessoas());
  module.exports = { lm35, ldr, dht11, tcrt5000, pessoas };
  
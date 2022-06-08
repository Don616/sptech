function tcrt5000(options) {
    minEntrada = options.minEnter;
    maxEntrada = options.maxEnter;
  
    minSaida = options.minExit;
    maxSaida = options.maxExit;
  
    if (minEntrada < 5 || maxEntrada > 12) {
      throw new Error(
        "Os valores minímos e máximos para umidade são 20% e 100% respectivamente."
      );
    }

    if (minSaida < 0 || maxSaida > 11) {
      throw new Error(
        "Os valores minímos e máximos para temperatura são 0 e 50 respectivamente."
      );
    }
  
    minEntrada = typeof minEntrada == "undefined" ? 5 : minEntrada;
    maxEntrada = typeof maxEntrada == "undefined" ? 12 : maxEntrada;
  
    minSaida = typeof minSaida == "undefined" ? 0 : minSaida;
    maxSaida = typeof maxSaida == "undefined" ? 11 : maxSaida;
  
    let randomEntrada = Math.floor(
      Math.random() * (maxEntrada - minSaida + 1) + minEntrada
    );
  
    let randomSaida =
      Math.random() * (maxEntrada - minEntrada);
  
    return [randomEntrada, randomSaida];
  }
  
  module.exports = { tcrt5000 };
  
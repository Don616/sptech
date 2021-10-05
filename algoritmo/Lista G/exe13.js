var temperatura;

function sortearTemperatura(){

    temperatura = (Math.random() * 40 - 20).toFixed(1)

    if(temperatura < 1){
        span_txt.innerHTML = `Dá pra conservar qualquer alimento`
    } else if(temperatura > 1 && temperatura <= 10){
        span_txt.innerHTML = `Conserva a maioria dos alimentos`;
    } else {
        span_txt.innerHTML = `Estraga a maioria dos alimentos`
    }
}
var multiplicador;
var num;

function verTabuada(){

    num = Number(input_num.value);
    var i=1;
    var total = 0;
    while(i < num){
        total = multiplicador * i

        span_tabuada.innerHTML += `${multiplicador} x ${i} = ${total}<br>`
        
        i++;
    }

}

function trocaTabuada(){
    multiplicador = Number(lista.value);
}
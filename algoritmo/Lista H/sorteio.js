
function main(){    

    var numero = Number(prompt("Escolha um numero"))
    
    i = 0;

    while(i < numero){

        var inteiro = Number((Math.random() * 100).toFixed(0))

        span_txt.innerHTML += `${i+1} numeros foram sorteados: ${inteiro}</span><br></br>`  

        if(inteiro % 6 == 0 || inteiro % 3 == 0){
            i += numero;
        }

        i++;

    }

}
var numero_sorteado = 0;
var numero_par = 0;
var numero_impar = 0;

function sortearNumero(){

    numero_sorteado = (Math.random() * 21 -30).toFixed(0);
    
    
    if(numero_sorteado % 2 == 0){

        numero_par++;

    } else {

        numero_impar++;
        
    }
    

    span_numero_sorteado.innerHTML = `${numero_sorteado}`;
    span_numeros_pares.innerHTML = `${numero_par}`;
    span_numeros_impares.innerHTML = `${numero_impar}`;

}   
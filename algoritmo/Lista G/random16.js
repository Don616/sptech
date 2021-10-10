var numero;
var sorteado;
var quantidade = 0;

function sortear(){

    quantidade++;

    if(input_numero_sorte.value >= 1 && input_numero_sorte.value <= 10){

        numero = Number(input_numero_sorte.value);

    } else {

        alert("Seu burro, era pra ser entre 1 e 10... agora deixa!")
        numero = (Math.random() * 9 +1).toFixed(0);

    }

    sorteado = (Math.random() * 9 +1).toFixed(0);

    if(numero == sorteado){
        span_texto.innerHTML = `Parabéns, ${input_nome.value}. Você foi sorteado(a) após ${quantidade} sorteios!
        <br>O número escolhido ${numero} é o número da sorte!`
    }

}
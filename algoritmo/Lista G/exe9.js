var nota;
var frequencia;

function gerarNota(){

    nota = (Math.random() * 7 + 3).toFixed(1);
    span_nota.innerHTML = `Sua nota é: ${nota}`;

}

function gerarFrequencia(){

    frequencia = (Math.random() * 50 +50).toFixed(0)
    span_frequencia.innerHTML = `Sua frequencia é: ${frequencia}%`;

}
function verificarAprovado(){

    if(nota >= 6 && frequencia >= 75){
        span_aprovado.style.color = "green";
        span_aprovado.innerHTML = `Você está APROVADO!`
    } else {
        span_aprovado.style.color = "red";
        span_aprovado.innerHTML = `Você está REPROVADO!`
    }

}

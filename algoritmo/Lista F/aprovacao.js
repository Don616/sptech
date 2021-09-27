function verificarAprovacao(){

    var presença = Number(input_presença.value);
    var nota = Number(input_nota.value);
    input_nota.value = ``;
    input_presença.value = ``;
    div_1.style.display = "block";


    if(nota >= 6 && presença >= 75){
        span_resultado.innerHTML = `APROVADO!`
    } else{
        span_resultado.innerHTML = `REPROVADO!`
    }


}
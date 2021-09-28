function verRecomendacao(){

    if(input_hora.value > 19 && input_hora.value < 21){
        span_txt.innerHTML = `Não é recomendável que você assista sua série favorita no horário ${input_hora.value}!`;
    } else {
        span_txt.innerHTML = `O horário ${input_hora.value} é adequado para assistir sua série favorita!`;
    }

}
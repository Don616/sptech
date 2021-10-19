function expressarAmor(){   

    var quantidade = Number(input_quanto.value)
    var contador = 1;

    while(contador < quantidade){

        span_txt.innerHTML += `${input_nome.value} eu te amo! <br>`;
        contador++;

    }

}
var resultado_atual;
var lista_resultado = [];
var quantidade_vitorias = 0;
var quantidade_empates = 0;
var quantidade_derrotas = 0;
var total = 0;
var aproveitamento = 0;

function trocaResultado(){ resultado_atual = select_resultado.value;  }

function registrarJogo(){

    if(resultado_atual == ''){
        alert('Escolha uma opção')
    } else {
        lista_resultado.push(resultado_atual);
        
    }

    contarLista()

}

function contarLista(){

    esvaziarLista()

    for(var i = 0; i < lista_resultado.length; i++){

        if(lista_resultado[i] == 'vitoria'){
            quantidade_vitorias++;
        } else if(lista_resultado[i] == 'empate'){
            quantidade_empates++;
        } else if(lista_resultado[i] == 'derrota'){
            quantidade_derrotas++;
        }

    }

    total = (quantidade_vitorias * 3) + (quantidade_empates);
    aproveitamento = (total / (lista_resultado.length * 3)) * 100

    exibe_texto.style.display = 'block';
    span_vitorias.innerHTML = `${quantidade_vitorias}`;
    span_empates.innerHTML = `${quantidade_empates}`;
    span_derrotas.innerHTML = `${quantidade_derrotas}`;
    span_pontos.innerHTML = `${total}`;
    span_aproveitamento.innerHTML = `${aproveitamento.toFixed(2)}`;

}
function querSaber(){

    if(lista_resultado == ''){

        alert('Não há nada para consultar')
        input_quer_saber.value = '';

    }else if(input_quer_saber.value > lista_resultado.length){

        alert('Ainda não tivemos esta quantidade de jogos')
        input_quer_saber.value = '';

    } else {

        p_txt.style.display = 'block';
        var consulta = input_quer_saber.value-1;
        span_numero_jogo.innerHTML = `${consulta+1}`;
        span_status.innerHTML = `${lista_resultado[consulta]}`;
        input_quer_saber.value = '';

    }


}

function esvaziarLista(){


    exibe_texto.style.display = 'none';
    span_vitorias.innerHTML = ``;
    span_empates.innerHTML = ``;
    span_derrotas.innerHTML = ``;
    span_pontos.innerHTML = ``;
    span_aproveitamento.innerHTML = ``;
    quantidade_vitorias = 0;
    quantidade_empates = 0;
    quantidade_derrotas = 0;
    total = 0;
    aproveitamento = 0;


}
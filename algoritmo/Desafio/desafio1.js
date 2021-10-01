var conta;
var digito;
var senha;
var valor_operacao;
var operacao_selecionada;
var prazo_selecionado;

function simular(){

    conta = Number(input_conta.value);
    digito = Number(input_digito.value);
    senha = input_senha.value;
    input_senha.value = ``;
    input_digito.value = ``;
    input_conta.value = ``; 

    if(conta != 0){
       if(digi to == conta % 11){
            if(senha == "manaus" && digito >= 0 && digito <= 3){
                alert('Bem vindo(a)');
                div1.style.display = 'none';
                div2.style.display = 'block';
            } else if(senha == "recife" && digito >= 4 && digito <= 7){
                alert('Bem vindo(a)');
                div1.style.display = 'none';
                div2.style.display = 'block';
            } else if(senha == "fortaleza" && digito > 7){
                alert('Bem vindo(a)');
                div1.style.display = 'none';
                div2.style.display = 'block';
            } else {
                alert('INCORRETO!!!!');
            }
        } else {
            alert('INCORRETO!!!!');
        }
    } else{
        alert('INCORRETO!!!!');
    }

}

function mostrarResultado(){

    valor_operacao = Number(input_valor_operacao.value);
    input_valor_operacao.value = ``;
    select1.value = ``;
    select2.value = ``;

    if(prazo_selecionado == "option_curto" || prazo_selecionado == "option_medio"){
        alert('Esta operação está condicionada ao seu perfil');
    }

}

function trocaSelect1(){

    operacao_selecionada = select1.value;

}
function trocaSelect2(){

    prazo_selecionado = select2.value;

}

function teste(){

    div1.style.display = 'none';
    div2.style.display = 'block';

}
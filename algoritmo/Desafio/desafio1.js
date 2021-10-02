var conta;
var digito;
var senha;
var valor_operacao;
var operacao_selecionada;
var prazo_selecionado;
var id_emprestimo = 0;
var id_investimento = 0;
var taxa_emprestimo;
var taxa_investimento;
var texto;

function simular(){

    conta = Number(input_conta.value);
    digito = Number(input_digito.value);
    senha = input_senha.value;
    input_senha.value = ``;
    input_digito.value = ``;
    input_conta.value = ``; 

    if(conta != 0){
       if(digito == conta % 11){
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
                alert('ACESSO NEGADO!');
            }
        } else {
            alert('ACESSO NEGADO!');
        }
    } else{
        alert('ACESSO NEGADO!');
    }

}

function mostrarResultado(){

    valor_operacao = Number(input_valor_operacao.value);


    console.log(prazo_selecionado)
    console.log(operacao_selecionada)
    console.log(valor_operacao)
    if(prazo_selecionado == undefined || operacao_selecionada == undefined || valor_operacao == 0){
        alert("Preencha TODOS os campos")
    }else{
        if(prazo_selecionado == "curto" || prazo_selecionado == "medio"){

            alert('Esta operação está condicionada ao seu perfil');
        }

        div2.style.display = 'none';
        div3.style.display = 'block';

        if(operacao_selecionada == "option_emprestimo"){

            emprestimo()
    
        } else if(operacao_selecionada == "option_investimento"){
    
            investimento()
    
        }
    }


}

function trocaSelect1(){

    operacao_selecionada = select1.value;

}
function trocaSelect2(){

    prazo_selecionado = select2.value;

}
/* 
function teste(){

    div1.style.display = 'none';
    div2.style.display = 'block';

}
*/
function emprestimo(){

    if(prazo_selecionado == "curto"){
        taxa_emprestimo = 0.24;
    } else if(prazo_selecionado == "medio"){
        taxa_emprestimo = 0.16;
    } else if(prazo_selecionado == "longo"){
        taxa_emprestimo = 0.10;
    }

    var calculo = taxa_emprestimo * valor_operacao;

    id_emprestimo++;
    span_id_emprestimo.innerHTML = `${id_emprestimo}`;
    span_valor_emprestimo.innerHTML = `${valor_operacao.toFixed(2)}`
    span_prazo_emprestimo.innerHTML = `${prazo_selecionado}`
    span_juros_emprestimo.innerHTML = `${calculo.toFixed(2)}`;
    span_simulacao_investimento.style.display = "none";
    span_simulacao_emprestimo.style.display = "block";
    texto = `<br>${span_simulacao_emprestimo.innerText}`;


}
function investimento(){

    if(prazo_selecionado == "curto"){
        taxa_emprestimo = 0.05;

    } else if(prazo_selecionado == "medio"){
        taxa_emprestimo = 0.08;

    } else if(prazo_selecionado == "longo"){
        taxa_emprestimo = 0.12;

    }

    var calculo = taxa_emprestimo * valor_operacao;
    
    id_investimento++;
    span_id_investimento.innerHTML = `${id_investimento}`;
    span_valor_investimento.innerHTML = `${valor_operacao.toFixed(2)}`
    span_prazo_emprestimo.innerHTML = `${prazo_selecionado}`
    span_rendimento_emprestimo.innerHTML = `${calculo.toFixed(2)}`;
    span_simulacao_emprestimo.style.display = "none";
    span_simulacao_investimento.style.display = "block";
    texto = `<br>${span_simulacao_investimento.innerText}`;
    
}

function voltar(){
    input_valor_operacao.value = ``;
    select1.value = ``;
    select2.value = ``;

    div3.style.display = 'none';
    div2.style.display = 'block';
    span_texto.innerHTML += `${texto}`;

}

function sair(){

    div2.style.display = 'none';
    div1.style.display = 'block';

}
var altura_piloto = 1.0;
var altura_basquete = 1.5;
var aprovação = 0;
var altura_inicial_piloto = 0;
var altura_inicial_basquete = 0;
var altura_final_piloto = 0;
var altura_final_basquete = 0;
var nome_candidato = "";
var altura_candito = 0;
var modalidade_candidato = "";


function verificarPiloto(){

    altura_inicial_piloto = Number(input_altura_piloto_inicial.value);
    altura_final_piloto = Number(input_altura_piloto_final.value);

    if(altura_inicial_piloto < altura_piloto && altura_final_piloto < altura_inicial_piloto){
        alert("Incorreto! Preencha novamente!");
        button_1.style.backgroundColor = "red";
        aprovação = 0;
    } else {
        aprovação = 1;
        button_1.style.backgroundColor = "green";
    }

}

function verificarBasquete(){

    altura_inicial_basquete = Number(input_altura_basquete_inicial.value);
    altura_final_basquete = Number(input_altura_basquete_final.value);

    if(altura_inicial_basquete < altura_basquete && altura_final_basquete < altura_inicial_basquete){
        alert("Incorreto! Preencha novamente!");
    } else {

        if(aprovação == 1){

            setHTML()
            resetDados()
            div_1.style.display = "none";
            div_2.style.display = "block";
            
        }
    }

}

function setHTML(){

    span_altura_inicial_piloto.innerHTML = `${altura_inicial_piloto}`;
    span_altura_final_piloto.innerHTML = `${altura_final_piloto}`;
    span_altura_inicial_basquete.innerHTML = `${altura_inicial_basquete}`;
    span_altura_final_basquete.innerHTML = `${altura_final_basquete}`;
    

}

function selectModalidade(){

    nome_candidato = input_nome_candidato.value;
    altura_candidato = input_altura_candidato.value;
    modalidade_candidato = select_modalidade.value;

    console.log(nome_candidato)
    console.log(altura_candidato)
    console.log(modalidade_candidato)

    if(modalidade_candidato == "piloto"){
        if(altura_candidato > altura_inicial_piloto && altura_candidato < altura_final_piloto){
            span_txt1.innerHTML = `O candidato ${nome_candidato} com altura de ${altura_candidato} participará do processo de seleção de piloto`;
        } else {
            span_txt1.innerHTML = `Infelizmente o candidato ${nome_candidato} com altura de ${altura_candidato} não atende os requisitos`
        }
        
    }

    if(modalidade_candidato == "basquete"){
        if(altura_candidato > altura_inicial_basquete && altura_candidato < altura_final_basquete){
            span_txt1.innerHTML = `O candidato ${nome_candidato} com altura de ${altura_candidato} participará do processo de seleção de basquete`;
        } else {
            span_txt1.innerHTML = `Infelizmente o candidato ${nome_candidato} com altura de ${altura_candidato} não atende os requisitos`
        }
        
    }

}

function resetDados(){

    input_nome_candidato.value = ``;
    input_altura_candidato.value = ``;
    select_modalidade.value = ``;
    input_altura_basquete_inicial.value = ``;
    input_altura_basquete_final.value = ``;
    input_altura_piloto_final.value = ``;
    input_altura_piloto_inicial.value = ``;
}
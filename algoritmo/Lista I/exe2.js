/*
COLE EM UM HTML!!!!
*/ 

    document.title = `Exe 2`;
    var viagens = [];

    var input = document.createElement('input');
    var botao1 = document.createElement('button');
    var botao2 = document.createElement('button');
    var botao3 = document.createElement('button');
    var botao4 = document.createElement('button');

    document.body.appendChild(input);
    document.body.appendChild(botao1);
    document.body.appendChild(botao2);
    document.body.appendChild(botao3);
    document.body.appendChild(botao4);

    input.setAttribute('id','input_lugar');
    botao1.innerHTML = `Cadastrar Lugar`;
    botao2.innerHTML = `Primeira Viagem`;
    botao3.innerHTML = `Terceira Viagem`;
    botao4.innerHTML = `Última Viagem`;

    botao1.addEventListener('click',()=>{

        if(input_lugar.value != ""){
            viagens.push(input_lugar.value);
        }
        
        input_lugar.value = ``;

    })
    botao2.addEventListener('click',()=>{

        if(viagens.length >= 1){
            alert(`Primeira viagem: ${viagens[0]}`)
        } else {
            alert("Ainda não foi para a primeira viagem")
        }

    })
    botao3.addEventListener('click',()=>{

        if(viagens.length >= 1){
            alert(`Terceira viagem: ${viagens[2]}`)
        } else {
            alert("Ainda não foi para a terceira viagem")
        }

    })
    botao4.addEventListener('click',()=>{

        if(viagens.length >= 1){
            alert(`Última viagem: ${viagens[viagens.length-1]}`)
        } else {
            alert("Ainda não foi para a primeira viagem")
        }

    })





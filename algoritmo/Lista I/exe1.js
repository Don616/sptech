/*
COLE EM UM HTML!!!!
*/ 

    document.title = "Exe 1"
    var frutas = ['banana','maçã','goiaba','tomate','morango','melão','melancia','fruta do conde']

    var botao = document.createElement('button');
    var input = document.createElement('input');
    document.body.appendChild(input);
    input.setAttribute('id','input_fruta');
    document.body.appendChild(botao);
    
    botao.innerHTML = `Pesquisar`
    botao.addEventListener('click',()=>{

        var x = frutas.indexOf(input_fruta.value);
        if(x == -1){
            alert(`Não existe a fruta ${input_fruta.value} na lista`)
            alert(`A fruta está na posição ${x}`)
        } else {
            alert(`A fruta ${input_fruta.value} existe na lista!`)
            alert(`A fruta está na posição ${x}`)
        }

    })
    


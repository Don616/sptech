/*
COLOQUE .html E ENVOLVA COM <script></script>
*/

    document.title = `Exe 3`
    var input = document.createElement('input');
    var botao = document.createElement('button');
    var br = document.createElement('br');
    var input2 = document.createElement('input');
    var botao2 = document.createElement('button');

    document.write('Escreva o bairro que você morou: ')
    document.body.appendChild(input)
    document.body.appendChild(botao)
    document.body.appendChild(br)
    document.write('Consulte o bairro aqui: ')
    document.body.appendChild(input2)
    document.body.appendChild(botao2)

    input.setAttribute('id','input_bairro');
    input2.setAttribute('id','input_relembrar');
    botao.innerHTML = `Cadastrar Bairro`
    botao2.innerHTML = `Relembrar Moradia`

    var bairros = [];
    botao.addEventListener('click', ()=>{

        bairros.push(input_bairro.value)
        input_bairro.value = ``;

    })
    botao2.addEventListener('click', ()=>{

        var num = input_relembrar.value-1;

        if(num > bairros.length){
            alert('Bairro ainda não cadastrado')
        } else if(input_relembrar.value == 0){
            alert('Bairro não cadastrado')
        } else {
            alert(`${bairros[num]}`)
        }
        

    })


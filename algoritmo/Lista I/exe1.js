<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
</body>
</html>
<script>

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
    
</script>

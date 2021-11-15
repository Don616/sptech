
var filhos = []
function cadastrar(){

    if(filhos.indexOf(input_filhos.value) != -1){
        alert("Não pode mais de 1 filho com o mesmo nome!")
    } else {
        filhos.push(input_filhos.value)
    }
    input_filhos.value = ``;
    console.log(filhos)
    
}

function atualizarFamilia(){

    var custo_particular = filhos.length * 3000;
    var custo_publico = filhos.length * 1500;

    span_quantidade_filhos.innerHTML = `${filhos.length}`;
    span_particular.innerHTML = `${custo_particular.toFixed(2)}`;
    span_publica.innerHTML = `${custo_publico.toFixed(2)}`;
    box1.style.display = 'block'

}


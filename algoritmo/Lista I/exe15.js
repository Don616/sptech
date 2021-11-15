var produtos = []
var preços = []
var maior_valor = 0;
var menor_valor = 1000000000000;
var soma_preço = 0;

function cadastrar(){

    if(produtos.indexOf(input_produto.value) == -1){
        produtos.push(input_produto.value)
        preços.push(Number(input_preço.value))
    } else (
        alert("Produto ja cadastrado")
    )
    console.log(produtos)
    console.log(preços)
    input_produto.value = ``;
    input_preço.value = ``;
}

function relatorioEstoque(){

    estoque.style.display = 'block';

    span_total.innerHTML = `${produtos.length}`;

    for(let i = 0; i < produtos.length;i++){

        span_relatorio.innerHTML += `<br>Produto ${i+1}: ${produtos[i]}<br>Preço de Compra: R$${preços[i].toFixed(0)}<br>Vender por: R$${(preços[i] * 1.25).toFixed(0)}<br>`;

        if(preços[i] > maior_valor){
            maior_valor = preços[i]
        } else if(preços[i] < menor_valor){
            menor_valor = preços[i]
        }

        soma_preço += preços[i];

        span_produto_caro.innerHTML = `${produtos[preços.indexOf(maior_valor)]}`;
        span_produto_barato.innerHTML = `${produtos[preços.indexOf(menor_valor)]}`;
        span_produto_soma.innerHTML = `${soma_preço}`;
        span_produto_media.innerHTML = `${soma_preço / preços.length}`;
    }

    

}
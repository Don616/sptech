function atualizarEstacao(idEstacao){

    var nome = input_nome_estacao.value;
    var linha = input_linha.value;
    var bairro = input_bairro.value;
    var cep = input_cep.value;
    
    idEstacao = sessionStorage.getItem("ID_ESTACAO")
    console.log(idEstacao)
    
    fetch(`/estacoes/atualizarEstacao/${idEstacao}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nomeServer: nome,
            linhaServer: linha,
            bairroServer: bairro,
            cepServer: cep
        })

    }).then(function (resposta) {

        // console.log("resposta: ", resposta);

        if (resposta.ok) {
            console.log(resposta);
            alert("Estacao atualizado com sucesso!!!")
        } else {
            throw ("Houve um erro ao tentar atualizar a estacao!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
        //finalizarAguardar();
    });

    return false;
}
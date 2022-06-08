function cadastrarEstacao(fkEmpresa){
        
    var nome = input_nome_estacao.value;
    var linha = input_linha.value;
    var bairro = input_bairro.value;
    var cep = input_cep.value;
    fkEmpresa = sessionStorage.getItem("ID_EMPRESA")
    console.log(fkEmpresa, nome, linha, bairro, cep)


    fetch(`estacoes/cadastrarEstacao/${fkEmpresa}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            linhaServer: linha,
            nomeServer: nome,
            bairroServer: bairro,
            cepServer: cep
        })
    }).then(function (resposta) {

        console.log("resposta: ", resposta);



        if (resposta.ok) {
            window.alert("Cadastro da estação realizado com sucesso!");

        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");

        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
        //finalizarAguardar();
    });

    return false
}
function atualizarTotem(hostname){

    var nomeEstacao = input_estacao.value;
    
     hostname = sessionStorage.getItem("HOSTNAME")
    console.log(hostname)
    
    fetch(`/totem/atualizarTotem/${hostname}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nomeEstacaoServer: nomeEstacao
        })

    }).then(function (resposta) {

        // console.log("resposta: ", resposta);

        if (resposta.ok) {
            console.log(resposta);
            alert("Totem atualizado com sucesso!!!")
            window.location = "./dashboard.html"
        } else {
            throw ("Houve um erro ao tentar atualizar o totem!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
        //finalizarAguardar();
    });

    return false;
}
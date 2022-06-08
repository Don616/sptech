function deletarEstacao(idEstacao) {

    idEstacao = sessionStorage.getItem("ID_ESTACAO")
    console.log(idEstacao)
    fetch(`/estacoes/deletarEstacao/${idEstacao}`, {
        method: "DELETE"
    }).then(function (resposta) {
            alert("Estacao removida com sucesso")
            window.location = "./dashboard.html"
            console.log(resposta)
        })
}
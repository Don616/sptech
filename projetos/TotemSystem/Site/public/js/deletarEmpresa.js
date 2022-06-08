function deletarEmpresa(id) {

    id = sessionStorage.getItem("ID_EMPRESA")
    console.log(id)
    fetch(`/usuarios/deletar/${id}`, {
        method: "DELETE"
    }).then(function (resposta) {
            alert("Empresa removida com sucesso")
            console.log(resposta)
            window.location = "./index.html"
        })
}
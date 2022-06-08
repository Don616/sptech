function deletarTotem(hostname) {

    hostname = sessionStorage.getItem("HOSTNAME")
    console.log(hostname)
    
    fetch(`totem/deletarTotem/${hostname}`, {
        method: "DELETE"
    }).then(function (resposta) {
        if(resposta == 200){
            alert("Totem removido com sucesso")
            window.location = "./dashboard.html"
            console.log(resposta)
        } else{
            alert("Totem em uso, faça backup dos dados antes de deletar")
        }
            
        })
}
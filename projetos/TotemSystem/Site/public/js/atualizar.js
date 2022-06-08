// const { json } = require("express/lib/response");

function atualizarCadastro(){
    var email = sessionStorage.getItem("EMAIL_EMPRESA");
    console.log(email)
    atualizar(email)
}

function atualizar(id){
    var razaoSocial = input_razao_social.value;
    var rua = input_rua.value;
    var numero = input_numero.value;
    var complemento = input_complemento.value;
    var telefone = input_telefone.value;
    
    id = sessionStorage.getItem("ID_EMPRESA")
    console.log(id)
    
    fetch(`/usuarios/atualizar/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            razaoSocialServer: razaoSocial,
            ruaServer: rua,
            numeroServer: numero,
            complementoServer: complemento,
            telefoneServer: telefone,
        })

    }).then(function (resposta) {

        // console.log("resposta: ", resposta);

        if (resposta.ok) {
            console.log(resposta);
            alert("Cadastro atualizado com sucesso!!!")

            resposta.json().then(json => {
                console.log(json);
                console.log(JSON.stringify(json));


                sessionStorage.RAZAO_SOCIAL = json.razaoSocialServer;
                sessionStorage.RUA_EMPRESA = json.ruaServer;
                sessionStorage.NUMERO_EMPRESA = json.numeroServer;
                sessionStorage.COMPLEMENTO_EMPRESA = json.complementoServer;
                sessionStorage.TELEFONE_EMPRESA = json.telefoneServer;

                
                localStorage.setItem('RAZAO_SOCIAL',json.razaoSocialServer)
                localStorage.setItem('RUA_EMPRESA',json.ruaServer)
                localStorage.setItem('NUMERO_EMPRESA',json.numeroServer)
                localStorage.setItem('COMPLEMENTO_EMPRESA',json.complementoServer)
                localStorage.setItem('TELEFONE_EMPRESA',json.telefoneServer)

                
            });
            window.location = "./user.html"
        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
        //finalizarAguardar();
    });

    return false;
}

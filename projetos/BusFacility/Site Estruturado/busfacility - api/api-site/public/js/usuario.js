// function cadastrarColaborador(){

//     pg0.style.display = `none`;
//     pg1.style.display = `flex`;
//     pg2.style.display = `none`;
//     pg3.style.display = `none`;
//     pg4.style.display = `none`;


// }

function cadastrarRotas(){

    pg0.style.display = `none`;
    pg1.style.display = `none`;
    pg2.style.display = `flex`;
    pg3.style.display = `none`;
    pg4.style.display = `none`;
    pg5.style.display = `none`;

}

function trocarUsuario(){

    pg0.style.display = `none`;
    pg1.style.display = `none`;
    pg2.style.display = `none`;
    pg3.style.display = `flex`;
    pg4.style.display = `none`;
    pg5.style.display = `none`;
}

function trocarSenha(){

    pg0.style.display = `none`;
    pg1.style.display = `none`;
    pg2.style.display = `none`;
    pg3.style.display = `none`;
    pg4.style.display = `flex`;
    pg5.style.display = `none`;


}

function adicionarColaborador(){

    pg0.style.display = `none`;
    pg1.style.display = `none`;
    pg2.style.display = `none`;
    pg3.style.display = `none`;
    pg4.style.display = `none`;
    pg5.style.display = `flex`;

}

function addColaborador() {

    var nomeVar = nome_colab.value;
    var senhaVar = senha_colab.value;
    var permissaoVar = permissao_colab.value;

    if (nomeVar == "" ||  senhaVar == "") {
l
        window.alert("Preencha todos os campos para prosseguir!");
        if (nomeVar == "") {
            console.log('nome está em branco')
        }
        if (senhaVar == "") {
            console.log('senha está em branco')
        }
        return false;
    }

    fetch("/bus/addColaborador", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nomeServer: nomeVar,
            senhaServer: senhaVar,
            permissaoServer: permissaoVar
        })
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Cadastro realizado com sucesso!");
            // window.location = "login.html";
            limparFormulario();
        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
    });

    return false;
}


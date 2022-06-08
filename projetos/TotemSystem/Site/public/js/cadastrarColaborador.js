function cadastrarColaborador(fkEmpresa){
        
    var nome = input_nome.value;
    var cpf = input_cpf.value;
    var cargo = input_cargo.value;
    var telefone = input_telefone_colaborador.value;
    var email = input_email.value;
    var senha = input_senha.value;
    fkEmpresa = sessionStorage.getItem("ID_EMPRESA")


    console.log(fkEmpresa, nome, cpf, cargo, telefone, email, senha)

    fetch(`/colaborador/cadastrarColaborador/${fkEmpresa}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nomeServer: nome,
            cpfServer: cpf,
            cargoServer: cargo,
            telefoneServer: telefone,
            emailServer: email,
            senhaServer: senha
        })
    }).then(function (resposta) {
        console.log("resposta: ", resposta);
        if (resposta.ok) {
            window.alert("Cadastro do colaborador realizado com sucesso!");
        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
        //finalizarAguardar();
    });

    return false
}
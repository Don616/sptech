var key_email = false;
var key_senha1 = false;
var key_senha2 = false;
var dica_ativa = false;

function cadastrar() {

    var nomeVar = input_social.value;
    var emailVar = input_email.value;
    var senhaVar = input_senha_1.value;
    var confirmacaoSenhaVar = input_senha_2.value;

    if (nomeVar == "" || emailVar == "" || senhaVar == "" || confirmacaoSenhaVar == "") {

        window.alert("Preencha todos os campos para prosseguir!");
        if (nomeVar == "") {
            console.log('nome está em branco')
        }
        if (emailVar == "") {
            console.log('email está em branco')
        }
        if (senhaVar == "") {
            console.log('senha está em branco')
        }
        if (confirmacaoSenhaVar == "") {
            console.log('confirmacaoSenha está em branco')
        }
        return false;
    }

    if (emailVar.indexOf("@") == -1 || emailVar.indexOf(".com") == -1) {
        window.alert("Ops, e-mail inválido! Verifique e tente novamente.");
        return false;
    }

    if (senhaVar != confirmacaoSenhaVar) {
        window.alert("As senhas inseridas devem ser iguais para prosseguir!");
        return false;
    }

    fetch("/usuarios/cadastrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nomeServer: nomeVar,
            emailServer: emailVar,
            senhaServer: senhaVar
        })
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Cadastro realizado com sucesso!");
            window.location = "login.html";
            limparFormulario();
        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
    });

    return false;
}

function enviarCadastro(){
    
    //console.log(key_email,key_senha1,key_senha2)
    if(key_email == true && key_senha1 == true && key_senha2 == true){
        
        cadastrar()
    }

}

function mostrarSenha(){

    var tipo_olho = input_senha_1.type;
    
    if(tipo_olho == 'text'){
        input_senha_1.type = 'password';
        imagem_olho.src = "../style/src/invisivel_senha.png";
    } else if(tipo_olho == 'password'){
        input_senha_1.type = 'text';
        imagem_olho.src = '../style/src/visivel_senha.png';
    } else{ //deixando esse else apenas para o caso do type mudar para algum outro sem querer
        input_senha_1.type = 'password';
        imagem_olho.src = "../style/src/invisivel_senha.png";
    }

}

function mostrarSenha_2(){
    var tipo_olho_2 = input_senha_2.type;
    
    if(tipo_olho_2 == 'text'){
        input_senha_2.type = 'password';
        imagem_olho_2.src = "../style/src/invisivel_senha.png";
    } else if(tipo_olho_2 == 'password'){
        input_senha_2.type = 'text';
        imagem_olho_2.src = "../style/src/visivel_senha.png";
    } else{ //deixando esse else apenas para o caso do type mudar para algum outro sem querer
        input_senha_2.type = 'password';
        imagem_olho.src = "../style/src/invisivel_senha.png";

    }

}
    

// function cadastrar(){
    
//     localStorage.setItem('cnpj',input_cnpj.value);
//     localStorage.setItem('social',input_social.value);
//     localStorage.setItem('email',input_email.value);
//     localStorage.setItem('telefone',input_telefone.value);
//     localStorage.setItem('senha',input_senha_1.value);
//     alert('Cadastro concluído com sucesso!')
//     window.location.href = '../html/loginV1.1.html'
    
// }

function alerta(self){

    self.style.border = '1px solid red';
    self.style.backgroundColor = '#FA8072';
    self.placeholder = '⚠';
    //self.value = ``;


}


function mudarBordaEmail(){

    if(input_email.value.indexOf('@') != -1 && input_email.value.endsWith('.com')){
        validado(input_email)
        key_email = true;
    } else {
        alerta(input_email)
        key_email = false;
    }

}
function mudarBordaSenha1(){

    if(input_senha_1.value.length < 8){

        alerta(input_senha_1);
        key_senha1 = false;

    } else {

        validado(input_senha_1)
        key_senha1 = true;

    }

}
function mudarBordaSenha2(){

    if(input_senha_1.value != input_senha_2.value || input_senha_2.value == '') {

        alerta(input_senha_2);
        key_senha2 = false;
    } else {

        validado(input_senha_2)
        key_senha2 = true;
    }
    
}

function validado(self){

    self.style.border = '1px solid green';
    self.style.backgroundColor = '#90EE90';
    //self.placeholder = '✔';
    //self.value = ``;

}

function voltarBordaEmail(){

    input_email.style.border = '1px solid black';
    input_email.style.backgroundColor = '#fff';
    input_email.placeholder = 'E-mail';

}
function voltarBordaSenha1(){

    input_senha_1.style.border = '1px solid black';
    input_senha_1.style.backgroundColor = '#fff';
    input_senha_1.placeholder = 'Senha';
}
function voltarBordaSenha2(){

    input_senha_2.style.border = '1px solid black';
    input_senha_2.style.backgroundColor = '#fff';
    input_senha_2.placeholder = 'Confirme sua senha';
    
}
function limparCache(){

    input_email.value = ``;
    input_senha_1.value = ``;
    input_senha_2.value = ``;

}
function dica(){

    if(dica_ativa == false){
        quadro.style.display = 'block';
        dica_ativa = true;
    } else {
        quadro.style.display = 'none';
        dica_ativa = false;
    }
    

}
var login = "aluno"
var senha = "digitalschool"
var codigo = "321"

function entrar(){

    if(input_login.value == login && input_senha.value == senha && input_codigo.value == codigo){
        window.location.href = "http://pudim.com.br/"
    }



}

function liberarCodigo(){

    if(input_senha.value == senha){
        span_codigo.style.display = "block";
    }

}
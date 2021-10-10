var key0 = false;
var key1 = false;
var key2 = false;
var key3 = false;
var key4 = false;
var key5 = false;
var key6 = false;
var key7 = false;
var key8 = false;
var key9 = false;
var key10 = false;
var quantidade = 0;
var num1 = 0;
var num2 = 0;
var num3 = 0;
var numero_sorteado;
var tentativas = 0;

function mudarCor(id){

    id.style.color = "#FF6347";
    id.style.backgroundColor = "#F8F8FF"
    id.style.border = "2px solid #B22222"

}
function voltarCor(id){

    id.style.color = "black";
    id.style.backgroundColor = "white"
    id.style.border = "2px solid black"

}
function verificarQuantidade(){

    if(quantidade > 0 && quantidade <= 3){
        botao_sorteio.style.display = "block";
    } else {
        botao_sorteio.style.display = "none";
    }

}

function sortear(){

    if(key0 == false){
        mudarCor(botao_sorteio)
        key0 = true
    }else {
        voltarCor(botao_sorteio)
        key0 = false
    }

    
    tentativas++;
    numero_sorteado = (Math.random() * 9 +1).toFixed(0);

    if(numero_sorteado == num1 || numero_sorteado == num2 || numero_sorteado == num3){
        resultado.innerHTML = `PARABÉNS, o numero sorteado ${numero_sorteado} foi escolhido depois de ${tentativas} tentativas!!!`
    }

}

function guardarNumero(numero){

    if(num1 == 0){
        num1 = numero;
    } else if(num2 == 0){
        num2 = numero;
    } else if(num3 == 0){
        num3 = numero;
    }

}
function limparNumero(numero){

    if(num1 == numero){
        num1 = 0;
    } else if(num2 == numero){
        num2 = 0;
    } else if(num3 == numero){
        num3 = 0;
    }

}

function b1(){
    
    if(key1 == false){
        guardarNumero(1)
        mudarCor(b_1)
        key1 = true; 
        quantidade += 1;
        verificarQuantidade()
    } else {
        limparNumero(1)
        voltarCor(b_1)
        key1 = false
        quantidade -= 1
        verificarQuantidade()
    }



}
function b2(){
    
    if(key2 == false){
        guardarNumero(2)
        mudarCor(b_2)
        key2 = true; 
        quantidade += 1;
        verificarQuantidade()
    } else {
        limparNumero(2)
        voltarCor(b_2)
        key2 = false
        quantidade -= 1
        verificarQuantidade()
    }

}
function b3(){
    
    if(key3 == false){
        guardarNumero(3)
        mudarCor(b_3)
        key3 = true; 
        quantidade += 1;
        verificarQuantidade()
    } else {
        limparNumero(3)
        voltarCor(b_3)
        key3 = false
        quantidade -= 1
        verificarQuantidade()
    }

}
function b4(){
    
    if(key4 == false){
        guardarNumero(4)
        mudarCor(b_4)
        key4 = true; 
        quantidade += 1;
        verificarQuantidade()
    } else {
        limparNumero(4)
        voltarCor(b_4)
        key4 = false
        quantidade -= 1
        verificarQuantidade()
    }

}
function b5(){
    
    if(key5 == false){
        guardarNumero(5)
        mudarCor(b_5)
        key5 = true; 
        quantidade += 1;
        verificarQuantidade()
    } else {
        limparNumero(5)
        voltarCor(b_5)
        key5 = false
        quantidade -= 1
        verificarQuantidade()
    }

}
function b6(){
    
    if(key6 == false){
        guardarNumero(6)
        mudarCor(b_6)
        key6 = true; 
        quantidade += 1;
        verificarQuantidade()
    } else {
        limparNumero(6)
        voltarCor(b_6)
        key6 = false
        quantidade -= 1
        verificarQuantidade()
    }

}
function b7(){
    
    if(key7 == false){
        guardarNumero(7)
        mudarCor(b_7)
        key7 = true; 
        quantidade += 1;
        verificarQuantidade()
    } else {
        limparNumero(7)
        voltarCor(b_7)
        key7 = false
        quantidade -= 1
        verificarQuantidade()
    }

}
function b8(){
    
    if(key8 == false){
        guardarNumero(8)
        mudarCor(b_8)
        key8 = true; 
        quantidade += 1;
        verificarQuantidade()
    } else {
        limparNumero(8)
        voltarCor(b_8)
        key8 = false
        quantidade -= 1
        verificarQuantidade()
    }

}
function b9(){
    
    if(key9 == false){
        guardarNumero(9)
        mudarCor(b_9)
        key9 = true; 
        quantidade += 1;
        verificarQuantidade()
    } else {
        limparNumero(9)
        voltarCor(b_9)
        key9 = false
        quantidade -= 1
        verificarQuantidade()
    }

}
function b10(){
    
    if(key10 == false){
        guardarNumero(10)
        mudarCor(b_10)
        key10 = true; 
        quantidade += 1;
        verificarQuantidade()
    } else {
        limparNumero(10)
        voltarCor(b_10)
        key10 = false
        quantidade -= 1
        verificarQuantidade()
    }

}
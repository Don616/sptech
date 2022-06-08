mudarTela()

function mvDashboard(){
    window.location = "./dashboard.html"
}

function sair(){
    window.location = "./index.html"
    sessionStorage.clear();
}

function voltar(){
    window.location = "./user.html"
}
function mudarTela(){

    var botao = document.getElementsByClassName('titulo_sidebar')

    for(let i = 0; i < botao.length;i++){

        botao[i].addEventListener('click',()=>{

            let clicado = event.target.innerHTML

            if(clicado == "Minha Conta"){
                tela_conta.style.display = 'flex'
            } else {
                tela_conta.style.display = 'none'
            }
            if(clicado == "Totens"){
                tela_totens.style.display = 'flex'
            } else {
                tela_totens.style.display = 'none'
            }
            if(clicado == "Colaboradores"){
                tela_colaboradores.style.display = 'flex'
            } else {
                tela_colaboradores.style.display = 'none'
            }
            if(clicado == "Estações"){
                tela_regioes.style.display = 'flex'
            } else {
                tela_regioes.style.display = 'none'
            }

        })
    }

    

}
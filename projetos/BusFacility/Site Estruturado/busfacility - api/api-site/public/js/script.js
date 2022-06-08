cabeça()
function cabeça(){

    var id_user = sessionStorage.ID_USUARIO;
    var nome = sessionStorage.NOME_USUARIO;
    
    //console.log(id_user)
    if(id_user != undefined){
        //console.log(id_user)
        header.style.display = `none`
        header2.style.display = `flex`
        usuario_logado.innerHTML = nome;
    } else {
        header.style.display = `flex`
        header2.style.display = `none`

    }
}
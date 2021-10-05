function sortearHora(){

    var hora = (Math.random() * 23).toFixed(0);

    if(hora >= 0 && hora <= 11){
        text.innerHTML = `Bom dia, flor do dia, são ${hora} horas!`;
    } else if(hora >= 12 && hora <= 17){
        text.innerHTML = `Boa tarde, já vai tarde! São ${hora} horas!`;
    } else{
        text.innerHTML = `Boa noite, durma bem! São ${hora} horas!`
    }


}
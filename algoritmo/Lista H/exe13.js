

function main(){

    var quantos_dias = Number(prompt("Quantos dias você faz musculação?",))
    var i = 1;
    var texto;

    while(i < 31){


        if(i %  quantos_dias == 1){
            texto = "Musculação"
        } else {
            texto = "Fiz nada!"
        }
        span_txt.innerHTML += `Dia ${i} - ${texto}<br>`;
        
        i++;
    }
}


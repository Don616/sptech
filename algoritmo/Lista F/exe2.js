function verificarAjuda(){

    var renda = Number(input_renda.value);
    var renda_total = Number(input_renda_total.value);
    input_renda.value = ``;
    input_renda_total.value = ``;

    if(renda <= 1050 && renda_total <= 2100){
        alert("Você terá direito!");
    } else {
        alert("Você NÃO terá direito!")
    }

}
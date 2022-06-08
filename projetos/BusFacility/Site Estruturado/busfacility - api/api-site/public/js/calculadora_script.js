function calcular() {
    // Transformando os inputs em variaveis
    var ax_gasolina = Number(ipt_gasolina.value);
    var ax_passageiros = Number(ipt_passageiros.value);
    var ax_onibus = Number(ipt_onibus.value);
    var ax_vezes = Number(ipt_vez.value)

    // Cálculos
    var ax_tarifa = ax_passageiros * 4.40;
    var ax_lucro = ax_tarifa * ax_onibus * ax_vezes;
    var ax_gasto = ax_gasolina * ax_onibus * ax_vezes;
    var ax_total = ax_lucro - ax_gasto;
    var ax_qto = ax_gasolina / 4.40;
    var ax_lucro_mes = ax_lucro * 30;
    var ax_gasto_mes = ax_gasto * 30;
    var ax_total_mes = ax_lucro_mes - ax_gasto_mes;
    
    // Mundando o que aparece na tela
    texto.style.display = 'none';
    calculo.style.display = 'flex';
    s_total.innerHTML = ax_total.toFixed(2);
    s_mes.innerHTML = ax_total_mes.toFixed(2)
    s_qto.innerHTML = ax_qto.toFixed(0);
}

function voltar(){

    texto.style.display = 'flex';
    calculo.style.display = 'none';
    ipt_gasolina.value = ''
    ipt_passageiros.value = ''
    ipt_onibus.value = ''
    ipt_vez.value = ''

}
// variaveis globais

var myChart1;
var myChart2;
var myChart3;
var frota_atual;
var semana_atual;
var h6,h7,h8,h9,h10,h11,h12,h13,h14,h15,h16,h17,h18,h19,h20,h21,h22,h23;
var lista_pessoas = []
var lista_entrada = []
var lista_saida = []

function quantidadeDado(user) {

    fetch(`/bus/quantidadedado/${user}`, { cache: 'no-store' }).then(function (response) {
        
        if (response.ok) {
            
            response.json().then(function (resposta) {
                
                //console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                resposta.reverse();
                //localStorage.setItem()
                localStorage.setItem('quantidadeDados',resposta[0].quantidade)
                
            });
        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });
}


function obterPassageiros(user) {

    fetch(`/bus/obterpassageiros/${user}`, { cache: 'no-store' }).then(function (response) {
        
        if (response.ok) {
            
            response.json().then(function (resposta) {
                
                //console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                resposta.reverse();
               // let qt_dados = localStorage.getItem('quantidadeDados');

                for (var i = 0; i < resposta.length; i++) {
                
                lista_entrada.push(Number(resposta[i].Entrada));
                lista_saida.push(Number(resposta[i].Saida));
                lista_pessoas.push(resposta[i].Entrada - resposta[i].Saida)
                
                }

                console.log(lista_pessoas)
                
            });
        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });
}

function main(){ 

    mostraGrafico()
    quantidadeDado()
    obterPassageiros()

}

function mostraGrafico(){ // Troca os tipos de graficos
    
    if(semana_atual == undefined || semana_atual == "x"){
        // console.log(semana_atual)
        canva3.style.display = 'none';
        canva1.style.display = 'flex';
        graficoBarra()
        // graficoPizza()

    } else {
        console.log(semana_atual)
        canva1.style.display = 'none';
        canva3.style.display = 'flex';
        graficoSemana()
        // graficoPizza()
    }   
}

function limparGrafico(){ //Para criar um gráfico novo é preciso destruir o anterior
    if(myChart1 != undefined){
        myChart1.destroy();
    }

    if(myChart2 != undefined){
        myChart2.destroy();
    }

    if(myChart3 != undefined){
        myChart3.destroy();
    }
}

function filtrarSemana(){ // Executa quando troca o select de semana
    limparGrafico()
    semana_atual = semana.value;
    main()
}

function filtrarFrota(){ // Executa quando troca o select de frota
    limparGrafico()
    frota_atual = filtrar.value;
    main()
}

function graficoBarra(){// Cria o gráfico de barra

    
var ctx = document.getElementById('canva1').getContext('2d');
myChart1 = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['6h','7h', '8h', '9h', '10h', '11h', '12h','13h','14h', '15h','16h','17h','18h','19h','20h','21h','22h','23h'],
        datasets: [{
            label: 'Nº de Passageiros',
            data: lista_pessoas,
            backgroundColor: [
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434'
            ],
            borderColor: [
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
}



function graficoPizza(){// Cria o gráfico de pizza

var manha = (Number(h6) + Number(h7) + Number(h8) + Number(h9) + Number(h10) + Number(h11))/6
var tarde = (Number(h12) + Number(h13) + Number(h14) + Number(h15) + Number(h16) + Number(h17))/6
var noite = (Number(h18) + Number(h19) + Number(h20) + Number(h21) + Number(h22) + Number(h23))/6
var total = manha + tarde + noite;
var porcent_manha = (manha * 100) / total;
var porcent_tarde = (tarde * 100) / total;
var porcent_noite = (noite * 100) / total;


var ctx = document.getElementById('canva2').getContext('2d');
myChart2 = new Chart(ctx, {
    type: 'pie',
    data: {
        //labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            //label: '# of Votes',
            data: [porcent_noite.toFixed(0), porcent_tarde.toFixed(0), porcent_manha.toFixed(0)],
            backgroundColor: [
                '#9BBB59',
                '#4F81BD',
                '#C0504D'
            ],
            borderColor: [
                '#9BBB59',
                '#4F81BD',
                '#C0504D'
            ],
            borderWidth: 1
        }]
    },

});
}

function graficoSemana(){ // Cria o gráfico de semana
    // Gráfico da Semana
    var ctx = document.getElementById('canva3').getContext('2d');
    myChart3 = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['6h','7h', '8h', '9h', '10h', '11h', '12h','13h','14h', '15h','16h','17h','18h','19h','20h','21h','22h','23h'],
        datasets: [{
            label: semana_atual,
            data: [h6,h7,h8,h9,h10,h11,h12,h13,h14,h15,h16,h17,h18,h19,h20,h21,h22,h23],
            backgroundColor: [
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434'
            ],
            borderColor: [
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434',
                '#C53434'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

}


function recarregar(){ // Executa ao recarregar a página

    filtrar.value = ``;
    // semana.value = 'x';
    var user = localStorage.getItem('social');
    usuario.innerHTML = `${user}!`

}

function teste() {
    lista_pessoas.forEach(data => {
        //Máximo de 60 itens exibidos no gráfico
        if (myChart1.data.labels.length == 10 && myChart1.data.datasets[0].data.length == 10) {
            myChart1.data.labels.shift();
            myChart1.data.datasets[0].data.shift();
        }
        myChart1.data.datasets[0].data.push(parseFloat(data));
        myChart1.update();
    });
}

// setInterval(() => {
//     // limparGrafico(),
//     // graficoBarra()
//     // teste()
// }, 3000);
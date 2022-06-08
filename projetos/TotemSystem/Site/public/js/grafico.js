const dataVol = {
    labels: [],
    datasets: [{
        label: 'Volume',
        backgroundColor: "red",
        borderColor: "red",
        data: []
    }]
};

const dataMem = {
    labels: [],
    datasets: [{
        label: 'Memória RAM',
        backgroundColor: "red",
        borderColor: "red",
        data: []
    }]
};

const dataProcesso = {
    labels: [],
    datasets: [{
        label: 'Processo',
        backgroundColor: "red",
        borderColor: "red",
        data: []
    }]
};

const dataServico = {
    labels: [],
    datasets: [{
        label: 'Serviços',
        backgroundColor: "red",
        borderColor: "red",
        data: []
    }]
};

// Chart para Volume
window.chartCpu = new Chart(
    document.getElementById('chartCpu'),
    config
);
chackGrafico = 1
console.log(dataVol)
setTimeout(() => atualizarGraficoDisco(dataVol, tamanhoUso),500);


// Chart para Memória RAM
window.chartMem = new Chart(
    document.getElementById('chartMem'),
    config
);
chackGrafico = 1
console.log(dataMem)
setTimeout(() => atualizarGraficoDisco(dataMem, tamanhoUso),500);


// Chart para Processos
window.chartProcessos = new Chart(
    document.getElementById('chartProcessos'),
    config
);
chackGrafico = 1
console.log(dataProcesso)
setTimeout(() => atualizarGraficoDisco(dataProcesso, tamanhoUso),500);

// Chart para Serviços
window.chartServicos = new Chart(
    document.getElementById('chartServicos'),
    config
);
chackGrafico = 1
console.log(dataServico)
setTimeout(() => atualizarGraficoDisco(dataServico, tamanhoUso),500);



function atualizarGraficoDisco(dados1, tamanhoUso) {
    console.log(dados1)
    fetch("/medidas/atualizarGraficoDisco", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        idDisco: idDisco,
        fkEquipamento: fkEquipamento,
        fkEmpresa: fkEmpresa

      })
    }).then(function (resposta) {
      console.log("ESTOU NO THEN DO entrar()!")
      if (resposta.ok) {
        resposta.json().then(json => {
          // console.log(json);
          // alert(json[0].memoria_uso)
     
          dadosHoraAtualizado = []
          tamanhoUsoAtualizado = []
          console.log(dados1)

          for (let i = 0; i < json.length; i++) {
            datasSeparacao = json[i].dataMedicao.split(" ");
            console.log(dados1.datasets[0].data);
            dados1.labels.push(datasSeparacao[1])
            console.log((json[i].tamanhoUso / 1073741824).toFixed(2))
            dados1.datasets[0].data.push((json[i].tamanhoUso / 1073741824).toFixed(2))
            memoriaDisponivel.innerHTML = `${(json[i].tamanhoDisponivel).toFixed(2)}GB`
            memoriaTotal.innerHTML = `${(json[i].tamanhoUso + json[i].tamanhoDisponivel).toFixed(2)}`
            //  setLegenda()
          }
          // if para checar se o vetor tem 16 posicoes e atualizar o gráfico 
          if(dados1.labels.length >= 16) {
            dados1.labels.shift();
            dados1.datasets[0].data.shift()
          }
        //  dados.labels.push(dadosHoraAtualizado[0])
          

          // setar legenda correta
          window.myChart.update()
          setLegenda();
          proximaAtualizacao = setTimeout(() => atualizarGraficoDisco(dados1, tamanhoUso), 5000);


        });
      } else {
        console.log("Houve um erro ao pegar informaçoes!");
        resposta.text().then(texto => {
          // console.error(texto);
          // finalizarAguardar(texto);
        });
      }
    }).catch(function (erro) {
      // console.log(erro);
    })

    return false;

  }













var campoChart = document.getElementById('campoChartMem')
var chart = document.createElement('canvas')
chart.setAttribute('id','chartMem')
chart.setAttribute('class','grafico')
document.campoChart.appendChild(chart)

// Sempre que add novo entregavel no trello, add na variavel x
// o valor deste entregavel em fibonnaci
var x = 215+5;


var ctx = document.getElementById('chart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['22/09', '27/09', '28/09', '29/09', '30/09', '04/10','05/10','06/10','07/10','13/10','14/10','18/10','19/10','20/10','21/10'],
        datasets: [{
            label: 'Gráfico BURNDOWN - Busfacility',
            data: [
                x,  //22/09
                x-15, //27/09
                x-15, //28/09
                x-15-21,  //29/09
                x-15-21-20, //30/09
                x-15-21-20-11,  //04/10
                x-15-21-20-11,  //05/10
                x-15-21-20-11-15, //06/10
		        x-15-21-20-11-15-13,  //07/10
                x-15-21-20-11-15-13-39, //13//10
                x-15-21-20-11-15-13-39-27,  //14/10
                x-15-21-20-11-15-13-39-27-18,  //18/10
                x-15-21-20-11-15-13-39-27-18-13, //19/10
                x-15-21-20-11-15-13-39-27-18-13-23,  //20/10
                x-15-21-20-11-15-13-39-27-18-13-23-5,  //21/10
            ],
            backgroundColor: [
                '#F22B0C'
            ],
            borderColor: [
                '#F22B0C'
            ],
            borderWidth: 3
        }]
    },
    options: {
        responsive: true,

        scales: {
            x:{grid:{tickColor:'blue'}, ticks:{color:'blue',fontSize:20}},
            y:{}
        },

        plugins:{

            legend:{labels:{font:{size: 14,weight:'bolder'}}},
            labels:{size: 15}

        }
    }
});


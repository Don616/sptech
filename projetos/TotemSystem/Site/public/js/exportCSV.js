function exportar(hostname) {
  // var  = [];
  // var quantidadeTotens = [];
  const rows = [];

  hostname = sessionStorage.getItem("HOSTNAME")

  fetch(`totem/getTotemLog/${hostname}`, {
    method: "GET",
  }).then(function (resposta) {
    resposta.json().then((json) => {

    // console.log(json)

    
    var headers = "hostname,id_log,memoria_uso,memoria_disponivel,total_processos,total_threads,total_servicos,total_servicos_ativos,total_servicos_inativos,volume_total,volume_disponivel,volume_em_uso,data_atual"
  
  let csvContent = "data:text/csv;charset=utf-8," + headers + "\n"
      // + rows.map(e => e.join(",")).join("\n");

   for (let index = 1; index < json.length; index++) {
     const element = json[index];
     console.log(element)
     csvContent += (Object.values(element)).map((e) => String(e)) + "\n"
   }
   
    var encodedUri = encodeURI(csvContent);
    var link = document.createElement("a");
    link.setAttribute("href", encodedUri);
    link.setAttribute("download", `${hostname}`);
    document.body.appendChild(link); // Required for FF
  
    link.click(); // This will download the data file named "my_data.csv".
    });
  });



}

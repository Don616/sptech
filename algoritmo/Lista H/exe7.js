function calcular(){

    var num = Number(input_numero.value)
    var i = 0;
    if(num < 20 || num > 100){
        alert("Seu numero não está nos parametros, vou setar como 50")
        num = 50;
    }
    while(i < num){

        if(i % 5 == 0){
            span_txt.innerHTML += `${i}<br>`; 
        }
        
        i++;
    }

}
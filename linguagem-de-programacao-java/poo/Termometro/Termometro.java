/*

Crie uma classe chamada Termometro. 

    Crie os atributos temperaturaAtual, temperaturaMax, temperaturaMin. 
    Crie um método chamado aumentaTemperatura, que recebe um valor para aumentar a temperatura atual. 
    Caso a nova temperatura seja maior do que a temperaturaMax, 
    atribua para a temperatura atual a temperaturaMax. 
    Crie um método chamado diminuiTemperatura, que recebe um valor para diminuir a temperatura atual. 
    Caso a nova temperatura seja menor do que a temperaturaMin, 
    atribua para a temperatura atual a temperaturaMin. 
    Crie um método chamado exibeFahreinheit, 
    que calcula e exibe a temperatura atual na escala de Fahreinheit. 
    Pesquise como é a fórmula para converter de Celsius para Fahreinheit. 
    Crie uma outra classe chamada TesteTermometro, 
    crie uma instância e seus execute os métodos para testar sua classe recém criada

*/

public class Termometro {

    private Double temperaturaAtual = 0.0;
    private Double temperaturaMax = 0.0;
    private Double temperaturaMin = 0.0;

    public Termometro(Double temperaturaAtual, Double temperaturaMax, Double temperaturaMin){

        this.setTempAtual(temperaturaAtual);
        this.setTempMax(temperaturaMax);
        this.setTempMin(temperaturaMin);

    }

    public void aumentaTemperatura(Double novaTemperatura){

        this.setTempAtual(novaTemperatura);

        if(novaTemperatura > this.getTempMax()){
            this.setTempAtual(this.getTempMax());
        }

    }


    public void diminuirTemperatura(Double novaTemperatura){

        this.setTempAtual(novaTemperatura);

        if(novaTemperatura < this.getTempMin()){
            this.setTempAtual(this.getTempMin());
        }

    }

    public Double exibeFahreinheit(){
        Double fahreinheit = (this.getTempAtual() * 1.8) + 32;
        return fahreinheit;
    }

    public Double getTempAtual(){
        return this.temperaturaAtual;
    }

    public void setTempAtual(Double temperaturaAtual){
        this.temperaturaAtual = temperaturaAtual;
    }

    public Double getTempMax(){
        return this.temperaturaMax;
    }

    public void setTempMax(Double temperaturaMax){
        this.temperaturaMax = temperaturaMax;
    }

    public Double getTempMin(){
        return this.temperaturaMin;
    }

    public void setTempMin(Double temperaturaMin){
        this.temperaturaMin = temperaturaMin;
    }
    
}

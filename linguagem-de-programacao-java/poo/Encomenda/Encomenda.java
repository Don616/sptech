/*

Crie um programa para gerenciar as encomendas de uma transportadora, 
que gere etiquetas para envio, e calcule o frete. 

Seu programa deve conter uma classe chamada Encomenda, que contenha os seguintes atributos: 

    tamanho (P, M ou G)
    enderecoRemetente (Ex: Rua Santos da Glória, 18) 
    enderecoDestinatario (Ex: Av Dr. Pedro, 255) 
    distancia(Ex: 42.2) 
    valorEncomenda (Ex: 87.50)

A classe deve conter os seguintes métodos: 

    calcularFrete: o método deve calcular o frete de acordo com a distância e tamanho da encomenda, 
    use a seguintes tabelas para o calculo:

Tamanho:

        P = 1% do valor da encomenda
        M = 3% do valor da encomenda
        G = 5% do valor da encomenda

Distância:

        Até 50km =  R$3,00
        Entre 51 e 200km = R$5,00
        Mais de 201km  = R$7,00


    emitirEtiqueta: ao ser invocado, o esse método deverá exibir as informações da encomenda, 
    exemplo:

***** ETIQUETA PARA ENVIO *****

Endereço do remetente: xxxxx

Endereço do destinatário: xxxx

Tamanho: "Pequeno", "Médio" ou "Grande"

--------------------------------------------------

Valor encomenda: R$ XX.XX

Valor frete: R$ XX.XX

--------------------------------------------------

Valor total: R$ XX.XX

*/

public class Encomenda {
    
    private Character tamanho = 'X';
    private String endereçoRemetente = "Endereço não definido";
    private String endereçoDestinatario = "Endereço não definido";
    private Double distancia = 0.0;
    private Double valorEncomenda = 0.0;
    private Double valorFrete = 0.0;

    public Encomenda(Character tamanho, String endereçoRemetente, String endereçoDestinatario, Double distancia, Double valorEncomenda){

        this.setTamanho(tamanho);
        this.setRemetente(endereçoRemetente);
        this.setDestinatario(endereçoDestinatario);
        this.setDistancia(distancia);
        this.setvalorEncomenda(valorEncomenda);


    }

    public void calcularFrete(){

        Double porcent = 0.0;
        Double adicional = 0.0;

        if(this.getTamanho().equals('P')){
            porcent = 0.01;
            this.setvalorFrete(this.getvalorEncomenda() * porcent);
        } else if(this.getTamanho().equals('M')){
            porcent = 0.03;
            this.setvalorFrete(this.getvalorEncomenda() * porcent);
        } else if(this.getTamanho().equals('G')){
            porcent = 0.05;
            this.setvalorFrete(this.getvalorEncomenda() * porcent);
        }

        if(this.getDistancia() <= 50.0){
            adicional = this.getvalorFrete() + 3.00;
            this.setvalorFrete(adicional);
        } else if(this.getDistancia() >= 51.0 && this.getDistancia() <= 200.0){
            adicional = this.getvalorFrete() + 5.00;
            this.setvalorFrete(adicional);
        } else if(this.getDistancia() > 200.0){
            adicional = this.getvalorFrete() + 7.00;
            this.setvalorFrete(adicional);
        }


    }

    public void emitirEtiqueta(){

        System.out.println("\n***** ETIQUETA PARA ENVIO *****\n");
        System.out.println(String.format(
            "Endereço do remetente: %s\n"
        ,this.getRemetente()));
        System.out.println(String.format(
            "Endereço do destinatário: %s\n"
        ,this.getDestinatario()));
        System.out.println(String.format(
            "Tamanho: %s\n"
        ,this.getTamanho()));
        System.out.println("\n--------------------------------------------------\n");
        System.out.println(String.format(
            "Valor encomenda: R$%.2f\n"
        ,this.getvalorEncomenda()));
        System.out.println(String.format(
            "Valor frete: R$%.2f\n"
        ,this.getvalorFrete()));
        System.out.println("\n--------------------------------------------------\n");
        System.out.println(String.format(
            "Valor total: R$%.2f\n"
        ,this.getvalorFrete() + this.getvalorEncomenda()));


    }

    public Character getTamanho(){
        return this.tamanho;
    }

    public void setTamanho(Character tamanho){
        if(tamanho.equals('P') || tamanho.equals('M') || tamanho.equals('G')){
            this.tamanho = tamanho;
        }
    }

    public String getRemetente(){
        return this.endereçoRemetente;
    }

    public void setRemetente(String endereçoRemetente){
        this.endereçoRemetente = endereçoRemetente;
    }

    public String getDestinatario(){
        return this.endereçoDestinatario;
    }

    public void setDestinatario(String endereçoDestinatario){
        this.endereçoDestinatario = endereçoDestinatario;
    }

    public Double getDistancia(){
        return this.distancia;
    }

    public void setDistancia(Double distancia){
        this.distancia = distancia;
    }

    public Double getvalorEncomenda(){
        return this.valorEncomenda;
    }

    public void setvalorEncomenda(Double valorEncomenda){
        this.valorEncomenda = valorEncomenda;
    }

    public Double getvalorFrete(){
        return this.valorFrete;
    }

    public void setvalorFrete(Double valorFrete){
        this.valorFrete = valorFrete;
    }
    


}

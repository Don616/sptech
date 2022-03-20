public class Bolo{

    private String sabor = "Não definido";
    private Double valor = 0.0;
    private Integer quantidadeVendida = 0;


    public Bolo(String sabor, Double valor, Integer quantidadeVendida){

        this.setSabor(sabor);
        this.setValor(valor);
        this.setQuantidadeVendida(quantidadeVendida);

    }

    public void comprarBolo(Integer quantidade){
        this.setQuantidadeVendida(quantidade);

        if(this.getQuantidadeVendida() > 100){
            this.setQuantidadeVendida(0);
            System.out.println("Seu pedido ultrapassou nosso limite diário para esse bolo.");
        } 
    }

    public void exibirRelatorio(){

        String sabor = this.getSabor();
        Double valor = this.getValor();
        Integer quantidadeVendida = this.getQuantidadeVendida();
        Double total = valor * quantidadeVendida;

        System.out.println(String.format(
            "O bolo sabor %s foi comprado %d vezes hoje, totalizando R$%.2f"
            ,sabor,quantidadeVendida,total));


    }

    public String getSabor(){
        return sabor;
    }

    public void setSabor(String sabor){
        if(sabor.equals("chocolate") || sabor.equals("morango") || sabor.equals("abacaxi")){
            this.sabor = sabor;
        }
        
    }

    public Double getValor(){
        return valor;
    }

    public void setValor(Double valor){
        if(valor >= 30.0 && valor <= 50.0){
            this.valor = valor;
        }
        
    }

    public Integer getQuantidadeVendida(){
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida){
        this.quantidadeVendida = quantidadeVendida;
    }




}
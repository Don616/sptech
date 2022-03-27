package PetShop;

public class PetShop {
    
    private String nome = "Não definido";
    private Double faturamento = 0.0;

    public PetShop(String nome){

        this.setNome(nome);
        

    }

    public void darBanho(Pet pet, Double valor){

        this.setFaturamento(this.getFaturamento() + valor);
        pet.setValorGasto(pet.getValorGasto() + valor);
        pet.setQtdVisitas(1);

    }

    public void darBanho(Pet pet, Double valor, Integer desconto){

        
        if(desconto >= 100){

            System.out.println("Não existe almoço grátis, AMIGÃO!");

        } else {
            
            Double porcent = desconto / 100.00;
            Double valorDesconto = (porcent * valor);
            
            this.setFaturamento(this.getFaturamento() + (valor - valorDesconto));
            pet.setValorGasto(pet.getValorGasto() + (valor - valorDesconto));
            pet.setQtdVisitas(1);

        }


    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setFaturamento(Double faturamento) {
        this.faturamento = faturamento;
    }

    public Double getFaturamento() {
        return faturamento;
    }

    @Override
    public String toString() {
        
        return String.format(""
        + "\nNome do Pet Shop: %s"
        + "\nFaturamento: %.2f",
        this.getNome(),this.getFaturamento());
    }

}

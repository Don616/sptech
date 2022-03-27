package PetShop;

public class Pet {
    
    private String nome = "Não definido";
    private String raca = "Não definido";
    private Integer qtdVisitas = 0;
    private Double valorGasto = 0.0;

    public Pet(String nome, String raca){

        this.setNome(nome);
        this.setRaca(raca);

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    public void setQtdVisitas(Integer qtdVisitas) {
        this.qtdVisitas += qtdVisitas;
    }

    public Integer getQtdVisitas() {
        return qtdVisitas;
    }

    public void setValorGasto(Double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Double getValorGasto() {
        return valorGasto;
    }

    @Override
    public String toString() {
        
        return String.format(""
        + "\nNome do pet: %s"
        + "\nRaça do pet: %s"
        + "\nQuantidade de visitas: %d"
        + "\nValor Gasto: %.2f",
        this.getNome(),this.getRaca(),this.getQtdVisitas(),this.getValorGasto());
    }

}

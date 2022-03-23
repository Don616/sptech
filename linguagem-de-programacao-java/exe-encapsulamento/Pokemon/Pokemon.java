public class Pokemon{

    private String nome = "Nome não definido";
    private String tipo = "Tipo não definido";
    private Double forca = 0.0;
    private Integer doces = 0;

    public Pokemon(String nome, String tipo, Double forca, Integer doces){
        
        this.setNome(nome);
        this.setTipo(tipo);
        this.setForca(forca);
        this.setDoces(doces);

    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public Double getForca(){
        return this.forca;
    }

    public void setForca(Double forca){
        this.forca = forca;
    }

    public Integer getDoces(){
        return this.doces;
    }

    public void setDoces(Integer doces){
        this.doces = doces;
    }

    @Override
    public String toString() {
        return "\nNome: "+this.getNome()+"\nTipo: "+this.getTipo()+"\nForça: "+this.getForca()+"\nQuantidade de Doces: "+this.getDoces();
    }


}
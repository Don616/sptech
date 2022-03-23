public class Colaborador{

    // Atributos =========================================

    private String nome = "Nenhum nome definido";
    private String cargo = "Nenhum cargo definido";
    private Double salario = 0.0;

    // Construtores ======================================

    public Colaborador(){

    }

    public Colaborador(String nome){
        this.setNome(nome);
    }

    public Colaborador(String nome, String cargo){
        this.setNome(nome);
        this.setCargo(cargo);
    }

    public Colaborador(String nome, String cargo, Double salario){
        this.setNome(nome);
        this.setCargo(cargo);
        this.setSalario(salario);
    }

    // Getters and Setters ===============================

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCargo(){
        return this.cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public Double getSalario(){
        return this.salario;
    }

    public void setSalario(Double salario){
        this.salario = salario;
    }


}
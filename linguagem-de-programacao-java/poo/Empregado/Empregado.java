/*

Crie uma classe chamada Empregado com os atributos nome, cargo e salario. 

Crie um método chamado reajustarSalario, que receberá como parâmetro a porcentagem do reajuste,
e atualiza o atributo salario.

Crie uma classe de teste chamada TesteEmpregado. 

    Dentro do método main, instancie um objeto da classe Empregado que tenha como nome “João”,
    salário inicial de R$ 5.400,00 e cargo “Analista de Sistemas”.
    Imprima na tela o nome, o cargo e o salário reajustado,
    sabendo que este empregado recebeu um reajuste salarial de 15%. 
    Crie outro objeto da classe Empregado e forneça atributos de sua escolha. 
    Depois imprima seus dados e também seu salário reajustado.

*/


public class Empregado {
    
    private String nome = "Nenhum nome definido";
    private String cargo = "Nenhum cargo definido";
    private Double salario = 0.00;

    public Empregado(String nome, String cargo, Double salario){

        this.setNome(nome);
        this.setCargo(cargo);
        this.setSalario(salario);

    }

    public void reajustarSalario(Integer porcentagemReajuste){

        Double porcentagem = porcentagemReajuste / 100.00;
        Double reajuste = porcentagem * this.salario;
        this.salario += reajuste;

    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public Double getSalario(){
        return salario;
    }

    public void setSalario(Double salario){
        this.salario = salario;
    }

    @Override
    public String toString() {
        
         return "\nNome: " + this.getNome() + ";\nCargo: "+ this.getCargo()+ ";\nSalário: "+ this.getSalario()+";\n";
    }

}

public class RecursosHumanos {
    
    private Integer totalPromovidos = 0;
    private Integer salariosReajustados = 0;

    public Integer getTotalPromovidos(){
        return this.totalPromovidos;
    }

    public void setTotalPromovidos(Integer totalPromovidos){
        this.totalPromovidos += totalPromovidos;
    }

    public Integer getSalarioReajustados(){
        return this.salariosReajustados;
    }

    public void setSalarioReajustados(Integer salarioReajustados){
        this.salariosReajustados += salarioReajustados;
    }


    public void reajustarSalarios(Colaborador colaborador, Double reajuste){

        Double porcent = reajuste / 100;
        Double salarioAdicional = colaborador.getSalario() * porcent;
        colaborador.setSalario(colaborador.getSalario() + salarioAdicional);
        this.setSalarioReajustados(1);

    }

    public void promoverColaborador(Colaborador colaborador, String cargo, Double salario){

        if(salario > colaborador.getSalario()){

            colaborador.setCargo(cargo);
            colaborador.setSalario(salario);
            this.setTotalPromovidos(1);

        } else {
            System.out.println("Operação inválida");
        }

    }


}

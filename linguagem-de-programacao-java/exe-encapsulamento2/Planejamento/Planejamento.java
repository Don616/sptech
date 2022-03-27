package Planejamento;

public class Planejamento{

    private String atividade = "Não definido";
    private String responsavel = "Não definido";
    private Integer diasEstimados = 0;
    private Integer diasUsados = 0; 

    public Planejamento(String atividade, String responsavel, Integer diasEstimados){

        this.setAtividade(atividade);
        this.setResponsavel(responsavel);
        this.setDiasEstimados(diasEstimados);

    }

    public void terminarAtividade(Integer diasUsados){
        Integer diasAtualizados = this.getDiasUsados() + diasUsados;
        setDiasUsados(diasAtualizados);
    }

    public String calcularTempo(){

        if(this.getDiasUsados() > this.getDiasEstimados()){
            return String.format(
                "Você estimou %d dias, mas a tarefa foi feita em %d dias (%d dias a mais que o estimado). Melhore a estimativa.",
                this.getDiasEstimados(),this.getDiasUsados(),(this.getDiasUsados() - this.getDiasEstimados()));
        } else if(this.getDiasUsados() < this.getDiasEstimados()){
            return String.format(
                "Você estimou %d dias, e a tarefa foi feita em %d dias (%d dias a menos que o estimado). Parabéns!",
                this.getDiasEstimados(),this.getDiasUsados(),(this.getDiasEstimados() - this.getDiasUsados()));
        } else if(this.getDiasUsados() == this.getDiasEstimados()){
            return String.format(
                "Você estimou %d dias, e a tarefa foi feita em %d dias, atendendo a estimativa com precisão!",
                this.getDiasEstimados(),this.getDiasUsados());
        } else {
            return "error";
        }
        
        
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setDiasEstimados(Integer diasEstimados) {
        this.diasEstimados = diasEstimados;
    }

    public Integer getDiasEstimados() {
        return diasEstimados;
    }

    public void setDiasUsados(Integer diasUsados) {
        this.diasUsados = diasUsados;
    }

    public Integer getDiasUsados() {
        return diasUsados;
    }

    @Override
    public String toString() {
        
        return String.format(""
            + "\nAtividade: %s"
            + "\nResponsável: %s"
            + "\nDias Estimados: %d"
            + "\nDias Usados: %d",
            this.getAtividade(),this.getResponsavel(),this.getDiasEstimados(),this.getDiasUsados());
    }


}
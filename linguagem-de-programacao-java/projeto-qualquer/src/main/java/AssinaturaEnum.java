package src.main.java;

public enum AssinaturaEnum {

    BRONZE("Plano Caro"),
    PRATA("Plano Médio"),
    OURO("Plano Barato");
    
    private String descricao;

    AssinaturaEnum(String descricao){
        this.descricao = descricao;
    }

    public static AssinaturaEnum getPorQtdCursos(Integer qtdCursos){

        if(qtdCursos >= 10){
            return OURO;
        } else if(qtdCursos >=5){
            return PRATA;
        } else {
            return BRONZE;
        }

    }

}
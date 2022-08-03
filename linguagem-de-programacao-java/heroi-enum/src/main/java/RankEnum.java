package src.main.java;

public enum RankEnum {

    S("Lendário",100),
    A("Muito Forte",50),
    B("Mediano",20),
    C("Fraco",10);

    private String descricao;
    private Integer bonusPorVitoria;

    RankEnum(String descricao, Integer bonusPorVitoria){
        this.descricao = descricao;
        this.bonusPorVitoria = bonusPorVitoria;
    }
}

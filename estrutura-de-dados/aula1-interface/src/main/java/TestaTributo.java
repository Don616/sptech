package src.main.java;

public class TestaTributo {

    public static void main(String[] args) {

        Alimento arroz = new Alimento(234,"Comida",7.50,200);
        Perfume kaiak = new Perfume(778,"Perfume Masculino",27.90,"Camomila");
        Servico pizzaria = new Servico("Serviço de Pizzaria",80.0);

        Tributo shopping = new Tributo();

        shopping.adicionaTributavel(arroz);
        shopping.adicionaTributavel(kaiak);
        shopping.adicionaTributavel(kaiak);
        shopping.adicionaTributavel(pizzaria);

        System.out.println(shopping.calculaTotalTributo());

        shopping.exibeTodos();


    }

}

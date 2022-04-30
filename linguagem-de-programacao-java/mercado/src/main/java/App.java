package src.main.java;

public class App {

    public static void main(String[] args) {

        Carrinho car1 = new Carrinho("Don");

        Produto prod1 = new Produto("Sabão","Limpeza",10.0);
        Produto prod2 = new Produto("Água","Alimento",3.0);
        Produto prod3 = new Produto("Biscoito","Alimento",4.0);
        Produto prod4 = new Produto("Detergente","Limpeza",1.0);
        Produto prod5 = new Produto("Calça","Vestuario",30.0);
        Produto prod6 = new Produto("Blusa","Vestuario",15.0);



        car1.adicionar(prod1);
        car1.adicionar(prod2);
        car1.adicionar(prod3);


        System.out.println(car1.getQuantidadePorCategoria("Limpeza"));
        System.out.println(prod1.getCategoria());
        System.out.println(car1.existsPorNome("Sabão"));
        System.out.println(car1.getValorTotal());
        System.out.println(car1);


    }

}

package src.main.java.empresa;

public class App {

    public static void main(String[] args) {

        Engenheiro eng = new Engenheiro("123","João",5000.00);
        Vendedor vend = new Vendedor("345","Maria",5.0,0.30);
        Horista hor = new Horista("789","Thomas",8,30.5);
        Horista hor2 = new Horista("789","Leandro",5,329.5);
        Horista hor3 = new Horista("789","Camila",3,40.5);
        Horista hor4 = new Horista("789","Israel",8,78.5);
        Horista hor5 = new Horista("789","Pedro",7,35.5);

        Empresa ltda = new Empresa();

        ltda.adicionarFuncionario(eng);
        ltda.adicionarFuncionario(vend);
        ltda.adicionarFuncionario(hor);
        ltda.adicionarFuncionario(hor2);
        ltda.adicionarFuncionario(hor3);
        ltda.adicionarFuncionario(hor4);
        ltda.adicionarFuncionario(hor5);

        ltda.exibeTotalSalario();
        ltda.exibeHoristas();


    }

}

package src.main.java;

public class Main {

    public static void main(String[] args) {
        Professor don = new Professor(3,15.0,"Don");
        Coordenador evy = new Coordenador(7,12.0,"Evy");

        ControleBonus controll = new ControleBonus();

        controll.adicionaEducador(don);
        controll.adicionaEducador(evy);
        System.out.println(controll.calculaTotal());

        controll.mostraEducador();
    }

}

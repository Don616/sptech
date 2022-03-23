public class TestePokemon {
    
    public static void main(String[] args) {
        
        TreinadorPokemon don = new TreinadorPokemon("Don");
        Pokemon pkm1 = new Pokemon("Pikachu", "Eletrico", 10.0, 5);
        Pokemon pkm2 = new Pokemon("Charmander", "Fogo", 50.0, 20);

        for(int i = 0; i < 10; i++){

            don.treinarPokemon(pkm1);

        }

        System.out.println(pkm1);
        don.evoluirPokemon(pkm1, "Raichu");
        System.out.println(pkm1);

        don.treinarPokemon(pkm2);
        don.treinarPokemon(pkm2);
        System.out.println(pkm2);
        don.evoluirPokemon(pkm2, "Charmeleon");

        System.out.println(don);

    }


}

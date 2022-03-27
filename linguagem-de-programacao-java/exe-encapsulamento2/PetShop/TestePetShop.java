package PetShop;

public class TestePetShop {
    
    public static void main(String[] args) {
        
        PetShop petLimpo = new PetShop("Pet Limpo");
        Pet astolfo = new Pet("Astolfo","Gato");

        petLimpo.darBanho(astolfo, 30.00);
        //System.out.println(astolfo);
        //System.out.println(petLimpo);

        for(int i = 0; i < 10; i++){
            petLimpo.darBanho(astolfo, 50.00, 10);
        }

        System.out.println(astolfo);
        System.out.println(petLimpo);
    }

}

/*

Crie uma classe chamada “NúmerosPares” que: 

    Exiba todos os números pares de 0 a 40 usando while

*/


public class NumerosPares {
    
    public static void main(String[] args){


        Integer num = 0;
        while(num <= 40){

            if(num % 2 == 0){

                System.out.println(num);

            }
            
            num++;

        }


    }


}

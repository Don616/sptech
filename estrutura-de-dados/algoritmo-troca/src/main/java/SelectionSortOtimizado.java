package src.main.java;

public class SelectionSortOtimizado {

    public static void main(String[] args) {

        Integer[] v = {3,5,6,7,3,4,5,12,1,3,5};
        int indMenor = 0;
        for(int i =0; i < v.length;i++){
            indMenor=i;
            for(int j=i+1;j<v.length;j++){
                if(v[j] < v[indMenor]){
                    indMenor=j;
                }
            }
        }

    }



}

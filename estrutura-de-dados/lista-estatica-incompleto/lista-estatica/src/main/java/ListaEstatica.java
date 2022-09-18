import java.util.Arrays;
import java.util.Objects;

public class ListaEstatica {

    // 01) Declarar vetor de int:
    // É inicializado no construtor
    Integer[] vetor;


    // 02) Criar atributo nroElem:
    // Tem dupla função: representa quantos elementos foram adicionado no vetor
    // Também o índice de onde será adicionado o próximo elemento
    private Integer nroElem = 0;



    // 03) Criar Construtor:
    // Recebe como argumento o tamanho máximo do vetor
    // Cria vetor com tamanho máximo informado
    // Inicializa nroElem
    public ListaEstatica(Integer tamMax){
        vetor = new Integer[tamMax];
    }



    // 04) Método adiciona:
    // Recebe o elemento a ser adicionado na lista
    // Se a lista estiver cheia usar IllegalStateException();
    public void adiciona(Integer elemento){

        if(nroElem== vetor.length){
            throw new IllegalStateException();
        } else {
            vetor[nroElem++] = elemento;
        }


    }


    // 05) Método busca:
    // Recebe o elemento a ser procurado na lista
    // Retorna o índice do elemento, se for encontrado
    // Retorna -1 se não encontrou
    public Integer busca(Integer elemento){
        int index=0;
        for(int e : vetor){

            if(elemento==e){
                return index;
            }
            index++;

        }
        return -1;
    }


    // 06) Método removePeloIndice:
    // Recebe o índice do elemento a ser removido
    // Se o índice for inválido, retorna false
    // Se removeu, retorna true
    public Boolean removePeloIndice(Integer indiceElemento){

        if(indiceElemento<nroElem&&indiceElemento>=0){
            vetor[indiceElemento]=null;
            return true;
        } else {
            return false;
        }

    }


    // 07) Método removeElemento
    // Recebe um elemento a ser removido
    // Utiliza os métodos busca e removePeloIndice
    // Retorna false, se não encontrou o elemento
    // Retorna true, se encontrou e removeu o elemento
    public Boolean removeElemento(Integer elemento){

        Integer contador = 0;
        for(Integer e : vetor){
            if(Objects.equals(e, elemento)){
                vetor[contador]=null;
                return true;
            }
            contador++;
        }
        return false;
    }


    // 08 Método exibe:
    // Exibe os elementos da lista
    public void exibe(){
        System.out.println(Arrays.toString(vetor));
    }


    //Métodos getVetor e getNroElem
    //São usados nos testes
    public Integer getNroElem() {
        Integer quantAtual = 0;
        for(Integer num : vetor){
            if(num!=null){
                quantAtual++;
            }
        }
        return quantAtual;
    }

    public Integer[] getVetor() {



        for(int i = 0; i< vetor.length-1;i++){

            for(int j = i+1; j < vetor.length;j++){

                if(vetor[i]==null){

                    Integer aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;

                }


            }

        }

        return vetor;
    }
}

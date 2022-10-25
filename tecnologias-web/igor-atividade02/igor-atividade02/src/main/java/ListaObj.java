public class ListaObj <T> {

    // 01) Declarar vetor de int:
    // É inicializado no construtor
    T[] vetor;

    // 02) Criar atributo nroElem:
    // Tem dupla função: representa quantos elementos foram adicionado no vetor
    // Também o índice de onde será adicionado o próximo elemento
    int nroElem = 0;

    // 03) Criar Construtor:
    // Recebe como argumento o tamanho máximo do vetor
    // Cria vetor com tamanho máximo informado
    // Inicializa nroElem

    public ListaObj(int tamanho) {
        this.vetor = (T[]) new Object[tamanho];
        this.nroElem = 0;
    }

    // 04) Método adiciona:
    // Recebe o elemento a ser adicionado na lista
    // Se a lista estiver cheia usar IllegalStateException();
    public void adiciona(T elemento){
        if (nroElem == vetor.length) {
            throw new IllegalStateException();
        } else {
            vetor[nroElem] = elemento;
            nroElem++;
        }
    }

    // 05) Método busca:
    // Recebe o elemento a ser procurado na lista
    // Retorna o índice do elemento, se for encontrado
    // Retorna -1 se não encontrou

    public int busca(T elemento){
        if (vetor.length==0) throw new IllegalStateException();

        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elemento)) return i;
        }
        return -1;
    }

    // 06) Método removePeloIndice:
    // Recebe o índice do elemento a ser removido
    // Se o índice for inválido, retorna false
    // Se removeu, retorna true

    public boolean removePeloIndice(int indice){
        if (vetor.length == 0 || indice >= nroElem || indice < 0){
            return false;
        }
        for (int i = indice; i< nroElem-1; i++){
            vetor[i] = vetor[i+1];
        }
        nroElem--;
        vetor[nroElem] = null;
        return true;
    }

    // 07) Método removeElemento
    // Recebe um elemento a ser removido
    // Utiliza os métodos busca e removePeloIndice
    // Retorna false, se não encontrou o elemento
    // Retorna true, se encontrou e removeu o elemento
    public boolean removeElemento(T elemento){
        for (int i = 0; i < nroElem; i++){
            if (vetor[i] == elemento){
                removePeloIndice(i);
                return true;
            }
        }
        return false;
    }

    // 08 Método exibe:
    // Exibe os elementos da lista
    public void exibe(){
        String str = "[";
        for (int i = 0; i < nroElem; i++) {
            if (i == nroElem-1){
                str += String.format("%d]", vetor[i]);
            } else{
                str += String.format("%d,", vetor[i]);
            }
        }
        System.out.println(str);
    }

    //Métodos getVetor e getNroElem
    //São usados nos testes
    public int getTamanho() {
        return nroElem;
    }

    public boolean substitui(T antigo, T novo){
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(antigo)) {
                vetor[i] = novo;
                return true;
            }
        }
        System.out.println("valor não encontrado");
        return false;
    }

    public int contarOcorrencias(T elemento){
        int count = 0;
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elemento)) count++;
        }
        return count;
    }

    public boolean adicionarNoInicio(T elemento){
        if (nroElem == vetor.length) {
            System.out.println("Lista cheia");
            return false;
        }
        for (int i = nroElem; i > 0; i--){
            vetor[i] = vetor[i-1];
        }
        vetor[0] = elemento;
        nroElem++;
        return true;
    }
    public T[] getVetor() {
        return vetor;
    }

    public T getElemento(int indice){
        if (vetor.length == 0 || indice >= nroElem || indice < 0){
            return null;
        }
        return vetor[indice];
    }

    public void limpa(){
        nroElem = 0;
    }
}


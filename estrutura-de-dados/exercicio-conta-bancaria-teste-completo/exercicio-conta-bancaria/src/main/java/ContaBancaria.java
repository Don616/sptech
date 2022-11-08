public class ContaBancaria {

    // Atributos
    private Integer numero;
    private Double saldo;

    // Construtor
    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    // Metodos

    public Boolean debitar(Double valor){
        if(valor == null || valor <= 0.0){
            throw new IllegalArgumentException();
        }
        if(valor > saldo) {
            return false;
        }
        saldo = saldo - valor;
        return true;
    }

    public void depositar(Double valor){
        if(valor == null || valor <= 0.0){
            throw new IllegalArgumentException();
        }else{
            saldo = saldo + valor;
        }
    }


    // Sobrescrita do metodo toString()
    @Override
    public String toString() {
        return String.format("\n----------Conta Bancária----------\n" +
                        "Número: %d\n" +
                        "Saldo: R$%.2f",
                numero, saldo);
    }

    // Getters and Setters
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}

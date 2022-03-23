public class TreinadorPokemon {
    
    private String nome = "Nome não definido";
    private Integer nivel = 0;

    public TreinadorPokemon(String nome){

        this.setNome(nome);

    }

    public void treinarPokemon(Pokemon pokemon){

        pokemon.setForca(pokemon.getForca() + (pokemon.getForca() * 0.10));      
        pokemon.setDoces(pokemon.getDoces() + 10);
        this.setNivel(this.getNivel() + 2);

    }

    public void evoluirPokemon(Pokemon pokemon, String nomeEvolucao){

        String nomeAntigo = pokemon.getNome();

        if(pokemon.getDoces() >= 50){
            pokemon.setNome(nomeEvolucao);
            pokemon.setDoces(pokemon.getDoces() - 50);
            this.setNivel(this.getNivel() + 10);
            System.out.println(String.format(
                "“Pokémon %s evoluiu para -> %s”",nomeAntigo,nomeEvolucao
            ));
        } else{
            System.out.println("Não foi possível realizar operação");
        }

    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Integer getNivel(){
        return this.nivel;
    }

    public void setNivel(Integer nivel){
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "\nNome: "+this.getNome()+"\nNível: "+this.getNivel();
    }

}

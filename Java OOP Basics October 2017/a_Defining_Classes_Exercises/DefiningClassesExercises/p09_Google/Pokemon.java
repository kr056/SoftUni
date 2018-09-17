package DefiningClassesExercises.p09_Google;

class Pokemon {
    private String pokemonName;
    private String pokemonType;

    Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    String getPokemonInfo() {
        return this.pokemonName + " " + this.pokemonType;
    }
}

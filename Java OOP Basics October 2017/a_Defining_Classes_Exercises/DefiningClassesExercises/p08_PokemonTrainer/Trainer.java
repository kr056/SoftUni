package DefiningClassesExercises.p08_PokemonTrainer;

import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private static final int DEFAULT_BADGES = 0;
    private String name;
    private int numberOfBadges = DEFAULT_BADGES;
    private List<Pokemon> pokemons;

    Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    List<Pokemon> getPokemons() {
        return pokemons;
    }

    int getNumberOfBadges() {
        return numberOfBadges;
    }

    void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    void reducePokemonsHealth(List<Pokemon> pokemons) {
        for (Pokemon poke : pokemons) {
            poke.setHealth(poke.getHealth() - 10);
        }

        this.pokemons = pokemons.stream()
                .filter(x -> x.getHealth() > 0)
                .collect(Collectors.toList());
    }

}

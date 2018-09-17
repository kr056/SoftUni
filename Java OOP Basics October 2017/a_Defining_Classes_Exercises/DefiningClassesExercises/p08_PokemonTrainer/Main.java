package DefiningClassesExercises.p08_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Trainer> pokeIndex = new LinkedHashMap<>();

        while (true) {
            String line = bf.readLine();

            if ("Tournament".equals(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];

            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.valueOf(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!pokeIndex.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName, new ArrayList<>());
                pokeIndex.put(trainer.getName(), trainer);
            }

            pokeIndex.get(trainerName).getPokemons().add(pokemon);
        }

        while (true) {
            String line = bf.readLine();

            if ("End".equals(line)) {
                break;
            }

            for (String trainerName : pokeIndex.keySet()) {
                boolean hasPokeOfThisType = false;
                List<Pokemon> pokemons = pokeIndex.get(trainerName).getPokemons();

                for (Pokemon poke : pokemons) {
                    if (poke.getElement().equalsIgnoreCase(line)) {
                        hasPokeOfThisType = true;
                        break;
                    }
                }

                if (hasPokeOfThisType) {
                    pokeIndex.get(trainerName).setNumberOfBadges(pokeIndex.get(trainerName).getNumberOfBadges() + 1);
                } else {
                    pokeIndex.get(trainerName).reducePokemonsHealth(pokeIndex.get(trainerName).getPokemons());
                }
            }
        }

        pokeIndex.entrySet().stream()
                .sorted((a, b) -> {
                    if (a.getValue().getNumberOfBadges() > b.getValue().getNumberOfBadges()) {
                        return -1;
                    } else if (a.getValue().getNumberOfBadges() == b.getValue().getNumberOfBadges()) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .forEach(s -> System.out.printf("%s %d %d%n", s.getKey(), s.getValue().getNumberOfBadges(), s.getValue().getPokemons().size()));
    }

}

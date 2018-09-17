package DefiningClassesExercises.p08_PokemonTrainer;

class Pokemon {
    private String name;
    private String element;
    private int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    void setHealth(int health) {
        this.health = health;
    }

    int getHealth() {
        return health;
    }

    String getElement() {
        return element;
    }
}

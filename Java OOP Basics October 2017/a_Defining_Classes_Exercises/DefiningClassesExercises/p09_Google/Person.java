package DefiningClassesExercises.p09_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String personName;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    void setPersonName(String personName) {
        this.personName = personName;
    }

    void setCompany(Company company) {
        this.company = company;
    }

    void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    void setChildren(List<Child> children) {
        this.children = children;
    }

    void setCar(Car car) {
        this.car = car;
    }

    void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    void addParent(Parent parent) {
        this.parents.add(parent);
    }

    void addChild(Child child) {
        if (this.children.size() == 0) {
            this.children = new ArrayList<>();
        }

        this.children.add(child);
    }

    private String getPokemons() {
        StringBuilder pokemonSb = new StringBuilder();

        for (Pokemon pokemon : this.pokemons) {
            pokemonSb.append(pokemon.getPokemonInfo()).append("\n");
        }

        return pokemonSb.toString();
    }

    private String getParents() {
        StringBuilder parentSb = new StringBuilder();

        for (Parent parent : this.parents) {
            parentSb.append(parent.getParentInfo()).append("\n");
        }

        return parentSb.toString();
    }

    private String getChildren() {
        StringBuilder childrenSb = new StringBuilder();

        for (Child child : this.children) {
            childrenSb.append(child.getChildInfo()).append("\n");
        }

        return childrenSb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.personName).append("\n");
        sb.append("Company:").append("\n");

        if (this.company != null) {
            sb.append(this.company.getCompanyInfo()).append("\n");
        }

        sb.append("Car:").append("\n");

        if (this.car != null) {
            sb.append(this.car.getCarInfo()).append("\n");
        }

        sb.append("Pokemon:").append("\n");
        sb.append(getPokemons());
        sb.append("Parents:").append("\n");
        sb.append(getParents());
        sb.append("Children:").append("\n");
        sb.append(getChildren()).append("\n");

        return sb.toString();
    }
}

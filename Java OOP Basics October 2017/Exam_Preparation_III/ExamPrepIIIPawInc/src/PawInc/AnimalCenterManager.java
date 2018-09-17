package PawInc;

import PawInc.Animals.Animal;
import PawInc.Centers.AdoptionCenter;
import PawInc.Centers.CastrationCenter;
import PawInc.Centers.CleansingCenter;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {

    private static HashMap<String, AdoptionCenter> adoptionCenters = new HashMap<>();
    private static HashMap<String, CleansingCenter> cleansingCenters = new HashMap<>();
    private static HashMap<String, CastrationCenter> castrationCenters = new HashMap<>();
    private static ArrayList<String> adoptedNames = new ArrayList<>();
    private static ArrayList<String> cleansedNames = new ArrayList<>();
    private static TreeSet<String> castratedNames = new TreeSet<>();


    public void registerAdoptionCenter(String name) {
        adoptionCenters.putIfAbsent(name, Factory.createAdoptionCenter(name));
    }

    public void registerCleansingCenter(String name) {
        cleansingCenters.putIfAbsent(name, Factory.createCleansingCenter(name));
    }

    public void registerCastrationCenter(String name) {
        castrationCenters.putIfAbsent(name, Factory.createCastrationCenter(name));
    }


    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        if (adoptionCenters.containsKey(adoptionCenterName)) {
            adoptionCenters.get(adoptionCenterName).addDog(Factory.createDog(name, age, learnedCommands));
        }
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        if (adoptionCenters.containsKey(adoptionCenterName)) {
            adoptionCenters.get(adoptionCenterName).addCat(Factory.createCat(name, age, intelligenceCoefficient));
        }
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        if (adoptionCenters.containsKey(adoptionCenterName) && cleansingCenters.containsKey(cleansingCenterName)) {
            for (Animal animal : adoptionCenters.get(adoptionCenterName).getStoredAnimals()) {
                if (animal.getCleansingStatus().equals("UNCLEANSED")) {
                    for (String str : castrationCenters.keySet()) {
                        if (!castrationCenters.get(str).getStoredAnimals().contains(animal)) {
                            cleansingCenters.get(cleansingCenterName).addAnimalForCleaning(animal);
                        }
                    }
                }
            }
        }
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        if (adoptionCenters.containsKey(adoptionCenterName) && castrationCenters.containsKey(castrationCenterName)) {
            for (Animal animal : adoptionCenters.get(adoptionCenterName).getStoredAnimals()) {
                if (animal.getCleansingStatus().equals("UNCLEANSED")) {
                    for (String str : cleansingCenters.keySet()) {
                        if (!cleansingCenters.get(str).getStoredAnimals().contains(animal)) {
                            castrationCenters.get(castrationCenterName).addAnimalForCleaning(animal);
                        }
                    }
                }
            }
        }
    }

    public void castrate(String castrationCenterName) {
        if (castrationCenters.containsKey(castrationCenterName)) {
            for (Animal animal : castrationCenters.get(castrationCenterName).getStoredAnimals()) {
                castratedNames.add(animal.getName());
            }
            castrationCenters.get(castrationCenterName).cleanCenter();
        }
    }

    public void cleanse(String cleansingCenterName) {
        if (cleansingCenters.containsKey(cleansingCenterName)) {
            for (Animal animal : cleansingCenters.get(cleansingCenterName).getStoredAnimals()) {
                animal.cleanAnimal();
                cleansedNames.add(animal.getName());
            }
            cleansingCenters.get(cleansingCenterName).cleanCenter();
        }
    }

    public void adopt(String adoptionCenterName) {
        if (adoptionCenters.containsKey(adoptionCenterName)) {
            for (Animal animal : adoptionCenters.get(adoptionCenterName).getStoredAnimals()) {
                if (animal.getCleansingStatus().equals("CLEANSED")) {
                    adoptedNames.add(animal.getName());
                }
            }
            List<Animal> animals = adoptionCenters.get(adoptionCenterName).getStoredAnimals().stream().filter(x -> x.getCleansingStatus().equals("UNCLEANSED"))
                    .collect(Collectors.toList());
            adoptionCenters.get(adoptionCenterName).setStoredAnimals(animals);
        }
    }

    public String castrationStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paw Inc. Regular Castration Statistics").append("\n");
        sb.append(String.format("Castration Centers: %d%n", castrationCenters.size()));
        if (castratedNames.size() == 0) {
            sb.append("Castrated Animals: None").append("\n");
        } else {
            sb.append("Castrated Animals: ").append(String.join(", ", castratedNames)).append("\n");
        }
        return sb.toString();
    }


    public void printStatistics() {
        StringBuilder sb = new StringBuilder();
        int animalsAwaitingAdoption = 0;
        int animalsAwaitingCleansing = 0;

        sb.append(castrationStatistics());
        sb.append("Paw Incorporative Regular Statistics").append("\n");
        sb.append(String.format("Adoption Centers: %d%n", adoptionCenters.size()));
        sb.append(String.format("Cleansing Centers: %d%n", cleansingCenters.size()));

        TreeSet<String> adoptedSet = new TreeSet<>();
        TreeSet<String> cleansedSet = new TreeSet<>();

        for (String str : adoptedNames) {
            adoptedSet.add(str);
        }
        for (String str : cleansedNames) {
            cleansedSet.add(str);
        }
        if (adoptedSet.size() == 0) {
            sb.append("Adopted Animals: None").append("\n");
        } else {
            sb.append("Adopted Animals: ").append(String.join(", ", adoptedSet)).append("\n");
        }
        if (cleansedSet.size() == 0) {
            sb.append("Cleansed Animals: None").append("\n");
        } else {
            sb.append("Cleansed Animals: ").append(String.join(", ", cleansedSet)).append("\n");
        }
        for (String key : adoptionCenters.keySet()) {
            for (Animal animal : adoptionCenters.get(key).getStoredAnimals()) {
                if (animal.getCleansingStatus().equals("CLEANSED")) {
                    animalsAwaitingAdoption++;
                }
            }
        }

        for (String key : cleansingCenters.keySet()) {
            animalsAwaitingCleansing += cleansingCenters.get(key).getStoredAnimals().size();
        }

        sb.append(String.format("Animals Awaiting Adoption: %d%n", animalsAwaitingAdoption));
        sb.append(String.format("Animals Awaiting Cleansing: %d%n", animalsAwaitingCleansing));
        System.out.print(sb.toString());
    }

}

package c_IteratorsAndComparators.Exercises.p08_PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Clinic> clinics = new HashMap<>();
        Map<String, Pet> pets = new HashMap<>();

        int cmdCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < cmdCount; i++) {
            String[] tokens = bf.readLine().split("\\s+");

            if ("Create".equals(tokens[0])) {
                switch (tokens[1]) {
                    case "Pet":
                        Pet pet = new Pet(tokens[2], Integer.valueOf(tokens[3]), tokens[4]);
                        pets.putIfAbsent(tokens[2], pet);
                        break;
                    case "Clinic":
                        try {
                            Clinic clinic = new Clinic(tokens[2], Integer.valueOf(tokens[3]));
                            clinics.putIfAbsent(tokens[2], clinic);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                }
            } else {
                switch (tokens[0]) {
                    case "HasEmptyRooms":
                        if (clinics.containsKey(tokens[1])) {
                            System.out.println(clinics.get(tokens[1]).hasEmptyRooms());
                        }
                        break;
                    case "Release":
                        if (clinics.containsKey(tokens[1])) {
                            System.out.println(clinics.get(tokens[1]).release());
                        }
                        break;
                    case "Add":
                        if (pets.containsKey(tokens[1]) && clinics.containsKey(tokens[2])) {
                            System.out.println(clinics.get(tokens[2]).addPet(pets.get(tokens[1])));
                        }
                        break;
                    case "Print":
                        if (tokens.length == 2) {
                            if (clinics.containsKey(tokens[1])) {
                                clinics.get(tokens[1]).forEach(r -> {
                                    if (r == null) {
                                        System.out.println("Room empty");
                                    } else {
                                        System.out.println(r.getPet().toString());
                                    }
                                });
                            }
                        }

                        if (tokens.length == 3) {
                            if (clinics.containsKey(tokens[1])) {
                                Room roomForPrint = clinics.get(tokens[1])
                                        .getRoomByIndex(Integer.valueOf(tokens[2]));

                                System.out.println(roomForPrint == null ? "Room empty" : roomForPrint.getPet().toString());
                            }
                        }
                        break;
                }
            }
        }
    }

}

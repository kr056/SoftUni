package d_EnumerationsAndAnnotations.Exercises.p10_InfernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Weapon> weapons = new HashMap<>();
        CustomClass annotations = (CustomClass) Weapon.class.getAnnotation(CustomClass.class);

        while (true) {
            String[] tokens = bf.readLine().split(";");

            if ("END".equals(tokens[0])) {
                break;
            }

            switch (tokens[0]) {
                case "Create":
                    WeaponKind weaponKind = WeaponKind.valueOf(tokens[1].toUpperCase());
                    Weapon weapon = new Weapon(tokens[2], weaponKind);
                    weapons.putIfAbsent(tokens[2], weapon);
                    break;
                case "Add":
                    if (weapons.containsKey(tokens[1])) {
                        weapons.get(tokens[1]).addGem(Gem.valueOf(tokens[3]),
                                Integer.valueOf(tokens[2]));
                    }
                    break;
                case "Remove":
                    if (weapons.containsKey(tokens[1])) {
                        weapons.get(tokens[1]).removeGem(Integer.valueOf(tokens[2]));
                    }
                    break;
                case "Print":
                    if (weapons.containsKey(tokens[1])) {
                        weapons.get(tokens[1]).print();
                    }
                    break;
                case "Compare":
                    if (weapons.containsKey(tokens[1])
                            && weapons.containsKey(tokens[2])) {
                        if (weapons.get(tokens[1]).compareTo(weapons.get(tokens[2])) >= 0) {
                            weapons.get(tokens[1]).printCompare();
                        } else {
                            weapons.get(tokens[2]).printCompare();
                        }
                    }
                    break;
                case "Author":
                    System.out.println("Author: " + annotations.author());
                    break;
                case "Revision":
                    System.out.println("Revision: " + annotations.revision());
                    break;
                case "Description":
                    System.out.println("Class description: " + annotations.description());
                    break;
                case "Reviewers":
                    System.out.println("Reviewers: " + annotations.reviewers());
                    break;
            }
        }
    }
}

package e_ObjectClassesAndCollectionsExercises;

import java.util.Scanner;
import java.util.TreeMap;

public class p11_Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, String> phonebook = new TreeMap<>();

        while (true) {
            String[] input = scan.nextLine().split("-");

            String name = input[0];

            if (name.equals("search")) {
                break;
            }

            String phone = input[1];

            if (!phonebook.containsKey(name)) {
                phonebook.put(name, phone);
            }

            phonebook.put(name, phone);
        }

        while (true) {
            String searchedName = scan.nextLine();

            if (searchedName.equals("stop")) {
                break;
            }

            if (phonebook.containsKey(searchedName)) {
                System.out.println(searchedName + " -> " + phonebook.get(searchedName));
            } else {
                System.out.println("Contact " + searchedName + " does not exist.");
            }
        }

    }
}

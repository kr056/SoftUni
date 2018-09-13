import java.util.Scanner;
import java.util.TreeMap;

public class p19_PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> phonebook = new TreeMap<>();

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");

            String cmd = input[0];
            String name = "";
            String number = "";

            if (cmd.equals("END")) {
                break;
            }

            if (cmd.equals("ListAll")) {

                for (String key : phonebook.keySet()) {
                    System.out.printf("%s -> %s", key, phonebook.get(key));
                    System.out.println();
                }
            }

            if (input.length > 1) {
                name = input[1];
            }

            if (cmd.equals("A")) {
                number = input[2];

                if (!phonebook.containsKey(name)) {
                    phonebook.put(name, number);
                }

                phonebook.put(name, number);
            }

            if (cmd.equals("S")) {
                if (phonebook.containsKey(name)) {
                    System.out.printf("%s -> %s", name, phonebook.get(name));
                } else {
                    System.out.printf("Contact %s does not exist.", name);
                }

                System.out.println();
            }
        }
    }
}

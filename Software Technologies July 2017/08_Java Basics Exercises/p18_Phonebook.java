import java.util.LinkedHashMap;
import java.util.Scanner;

public class p18_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");

            String cmd = input[0];
            String name = "";
            String number = "";

            if (cmd.equals("END")) {
                break;
            }

            name = input[1];

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

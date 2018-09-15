package d_DataRepresentationAndManipulationExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09_PhoneNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern pattern = Pattern.compile("([A-Z](?:[a-zA-Z]+)?)([^a-zA-Z+]*[+]?[0-9]+[()/.\\-]*[0-9]+(?:[().\\- ]+[0-9]+)*)");

        Map<String, String> phonebook = new LinkedHashMap<>();

        String text = "";

        boolean matchFound = false;

        while (true) {
            String input = scan.nextLine();

            if (input.equals("END")) {
                break;
            }

            text += input;
        }

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            matchFound = true;
            String name = matcher.group(1).trim();
            String number = matcher.group(2);
            number = number.replaceAll("[^\\d+]+", "");
            phonebook.put(name, number);
        }

        int count = 0;

        if (!matchFound) {
            System.out.println("<p>No matches!</p>");
            return;
        }

        StringBuilder sb = new StringBuilder("<ol>");

        for (String key : phonebook.keySet()) {
            String value = phonebook.get(key);
            sb.append("<li><b>").append(key).append(":</b> ").append(value).append("</li>");
        }

        sb.append("</ol>");

        System.out.println(sb);
    }
}

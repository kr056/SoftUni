package c_StringProcessingExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p12_ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String emails = scan.nextLine();

            if (emails.equals("end")) {
                break;
            }

            Pattern pattern = Pattern.compile("(?<=\\s|^)[a-z0-9]+([-.]\\w*)*@[a-z]+([-.]\\w*)*(\\.[a-z]+)");
            Matcher matcher = pattern.matcher(emails);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
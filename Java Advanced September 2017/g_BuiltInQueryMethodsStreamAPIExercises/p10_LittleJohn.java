package g_BuiltInQueryMethodsStreamAPIExercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class p10_LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<small>>----->)|(?<med>>>----->)|(?<large>>>>----->>)");

        int smallCount = 0;
        int mediumCount = 0;
        int largeCount = 0;


        for (int i = 0; i < 4; i++) {
            String input = bf.readLine();

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {

                if (matcher.group("large") != null) {
                    largeCount++;
                } else if (matcher.group("med") != null) {
                    mediumCount++;
                } else {
                    smallCount++;
                }
            }
        }

        String conc = Integer.toString(smallCount) + Integer.toString(mediumCount) + Integer.toString(largeCount);
        int concNumber = Integer.parseInt(conc);

        String binaryNumber = Integer.toBinaryString(concNumber);
        String binaryNumberReversed = "";

        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            binaryNumberReversed += binaryNumber.charAt(i);
        }

        String finalBinary = binaryNumber + binaryNumberReversed;
        int result = Integer.parseInt(finalBinary, 2);

        System.out.println(result);
    }
}

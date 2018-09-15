package ExamPreparationI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> info = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("([,_])([a-zA-Z]+)(\\d)");

        while (true) {
            String line = bf.readLine();

            if ("Ascend".equals(line)) {
                break;
            }

            for (String key : info.keySet()) {
                if (line.contains(key)) {
                    line = line.replace(key, info.get(key));
                }
            }

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String match = matcher.group();
                String charSeq = matcher.group(2);
                String result = "";

                for (int i = 0; i < charSeq.length(); i++) {
                    if (match.charAt(0) == '_') {
                        result += (char) (Math.abs(charSeq.charAt(i) - Integer.parseInt(matcher.group(3))));
                    } else if (match.charAt(0) == ',') {
                        result += (char) (Math.abs(charSeq.charAt(i) + Integer.parseInt(matcher.group(3))));
                    }
                }

                info.put(match, result);
                line = line.replace(match, result);
            }

            System.out.println(line);
        }
    }
}

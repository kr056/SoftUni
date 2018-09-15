package g_BuiltInQueryMethodsStreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p11_OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, LinkedHashMap<String, Integer>> office = new TreeMap<>();

        int lineCount = Integer.parseInt(bf.readLine());

        Pattern pattern = Pattern.compile("[^|\\s-]+");

        for (int i = 0; i < lineCount; i++) {
            String input = bf.readLine();
            Matcher matcher = pattern.matcher(input);

            List<String> info = new ArrayList<>();

            while (matcher.find()) {
                info.add(matcher.group());
            }

            String company = info.get(0);
            String product = info.get(2);
            int amount = Integer.parseInt(info.get(1));

            if (!office.containsKey(company)) {
                office.put(company, new LinkedHashMap<>());
                office.get(company).put(product, 0);
            }

            if (!office.get(company).containsKey(product)) {
                office.get(company).put(product, amount);
            } else {
                office.get(company).put(product, office.get(company).get(product) + amount);
            }

            info.clear();
        }

        for (String key : office.keySet()) {
            System.out.printf("%s: ", key);

            int counter = 0;
            int size = office.get(key).size();

            for (String insideKey : office.get(key).keySet()) {
                if (office.get(key).size() - 1 == counter) {
                    System.out.printf("%s-%d\n", insideKey, office.get(key).get(insideKey));
                } else {
                    System.out.printf("%s-%d, ", insideKey, office.get(key).get(insideKey));
                    counter++;
                }
            }

        }
    }
}

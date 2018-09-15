package ExamPreparationII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p01_HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split("\\s+");

        ArrayDeque<String> cards = new ArrayDeque<>();
        cards.addAll(Arrays.asList(input));

        int totalSum = 0;

        while (!cards.isEmpty()) {
            String element = cards.pop();

            int seqSum = getCardPower(element);
            int count = 1;

            while (cards.peek() != null && cards.peek().substring(cards.peek().length() - 1).equals(element.substring(element.length() - 1))) {
                count++;
                seqSum += getCardPower(cards.pop());
            }

            totalSum += seqSum * count;
        }

        System.out.println(totalSum);

    }

    private static int getCardPower(String element) {

        int power = 0;

        String cardType = element.substring(0, element.length() - 1);

        List<String> flush = new ArrayList<>();
        Collections.addAll(flush, "A", "K", "Q", "J");

        if (flush.contains(cardType)) {
            switch (cardType) {
                case "A":
                    power = 15;
                    break;
                case "K":
                    power = 14;
                    break;
                case "Q":
                    power = 13;
                    break;
                case "J":
                    power = 12;
                    break;
            }
        } else {
            power = Integer.parseInt(cardType);
        }
        return power;
    }
}

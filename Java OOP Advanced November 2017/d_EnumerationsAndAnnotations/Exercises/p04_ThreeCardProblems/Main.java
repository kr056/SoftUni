package d_EnumerationsAndAnnotations.Exercises.p04_ThreeCardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //CompareTo Task
        String rank = bf.readLine();
        String suit = bf.readLine();

        String secondRank = bf.readLine();
        String secondSuit = bf.readLine();

        Card card = new Card(rank, suit);
        Card card2 = new Card(secondRank, secondSuit);

        if (card.compareTo(card2) > 0) {
            System.out.println(card);
        } else if (card.compareTo(card2) < 0) {
            System.out.println(card2);
        } else {
            System.out.println(card);
        }

        // Annotation Task
        String value = bf.readLine();

        if ("Rank".equals(value)) {
            System.out.println("Type = " + Rank.class.getAnnotation(Custom.class).type()
                    + ", Description = " + Rank.class.getAnnotation(Custom.class).description());
        } else {
            System.out.println("Type = " + Suit.class.getAnnotation(Custom.class).type()
                    + ", Description = " + Suit.class.getAnnotation(Custom.class).description());

        }

        // Task 7 Card Deck

        for (Suit suitEnum : Suit.values()) {
            for (Rank rankEnum : Rank.values()) {
                System.out.println(rankEnum.name() + " of " + suitEnum.name());
            }
        }
    }
}

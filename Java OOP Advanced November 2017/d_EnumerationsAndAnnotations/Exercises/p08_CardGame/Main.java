package d_EnumerationsAndAnnotations.Exercises.p08_CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> playerOneCards = new ArrayList<>();
        List<Integer> playerTwoCards = new ArrayList<>();
        Map<String, Integer> deck = new HashMap<>();

        fillDeck(deck);

        String playerOneName = bf.readLine();
        String playerTwoName = bf.readLine();

        playerDeckFiller(bf, playerOneCards, playerTwoCards, deck);
        playerDeckFiller(bf, playerTwoCards, playerOneCards, deck);

        int playerOneBestCard = playerOneCards.stream()
                .mapToInt(Integer::valueOf)
                .max()
                .getAsInt();


        int playerTwoBestCard = playerTwoCards.stream()
                .mapToInt(Integer::valueOf)
                .max()
                .getAsInt();

        String nameOne = "";
        String nameTwo = "";

        for (String key : deck.keySet()) {
            if (deck.get(key) == playerOneBestCard) {
                nameOne = key;
            }
            if (deck.get(key) == playerTwoBestCard) {
                nameTwo = key;
            }
        }

        if (playerOneBestCard > playerTwoBestCard) {
            System.out.println(playerOneName + " wins with "
                    + nameOne + ".");
        } else if (playerTwoBestCard > playerOneBestCard) {
            System.out.println(playerTwoName + " wins with "
                    + nameTwo + ".");
        }
    }

    private static void playerDeckFiller(BufferedReader bf, List<Integer> playerOneCards, List<Integer> playerTwoCards, Map<String, Integer> deck) throws IOException {
        while (playerOneCards.size() < 5) {
            String cardName = bf.readLine();

            if (deck.containsKey(cardName)) {
                if (!playerOneCards.contains(deck.get(cardName)) &&
                        !playerTwoCards.contains(deck.get(cardName))) {
                    playerOneCards.add(deck.get(cardName));
                } else {
                    System.out.println("Card is not in the deck.");
                }
            } else {
                System.out.println("No such card exists.");
            }
        }
    }

    private static void fillDeck(Map<String, Integer> deck) {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank.toString(), suit.toString());
                deck.putIfAbsent(rank.name() + " of " + suit.name(), card.getPower());
            }
        }
    }
}

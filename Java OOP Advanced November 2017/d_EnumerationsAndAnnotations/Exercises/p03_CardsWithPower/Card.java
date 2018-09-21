package d_EnumerationsAndAnnotations.Exercises.p03_CardsWithPower;

public class Card {
    private String name;
    private int power;

    public Card(String rank, String suit) {
        this.name = Rank.valueOf(rank.toUpperCase()).name() + " of " + Suit.valueOf(suit.toUpperCase());
        this.power = Rank.valueOf(rank.toUpperCase()).getRankPower() + Suit.valueOf(suit.toUpperCase()).getSuitPower();
    }

    public String toString() {
        return "Card name: " + this.name + "; Card power: " + this.power;
    }
}

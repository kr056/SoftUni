package d_EnumerationsAndAnnotations.Exercises.p04_ThreeCardProblems;

@Custom(category = "Suit", description = "Provides suit constants for a Card class.")
public enum Suit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int suitPower;

    Suit(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return suitPower;
    }
}

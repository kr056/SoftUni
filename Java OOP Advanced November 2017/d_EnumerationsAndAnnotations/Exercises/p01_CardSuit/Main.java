package d_EnumerationsAndAnnotations.Exercises.p01_CardSuit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Card Suits:");

        for(Suit suit : Suit.values()){
            System.out.println("Ordinal value: " + suit.ordinal() + "; Name value: " + suit.name());
        }
    }
}

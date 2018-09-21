package d_EnumerationsAndAnnotations.Exercises.p03_CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String rank = bf.readLine();
        String suit = bf.readLine();

        Card card = new Card(rank, suit);

        System.out.println(card);
    }
}

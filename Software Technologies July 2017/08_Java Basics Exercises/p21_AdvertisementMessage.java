import java.util.Random;
import java.util.Scanner;

public class p21_AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] phrases = new String[]{"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can't live without this product."};

        String[] events = new String[]{"Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"};

        String[] author = new String[]{"Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya", "Iva", "Annie", "Eva"};

        String[] cities = new String[]{"Burgas",
                "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            int phraseIndex = rnd.nextInt(phrases.length);
            int eventsIndex = rnd.nextInt(events.length);
            int authorIndex = rnd.nextInt(author.length);
            int citiesIndex = rnd.nextInt(cities.length);

            System.out.printf("%s %s %s - %s", phrases[phraseIndex],
                    events[eventsIndex],
                    author[authorIndex],
                    cities[citiesIndex]);
            System.out.println();
        }

    }
}

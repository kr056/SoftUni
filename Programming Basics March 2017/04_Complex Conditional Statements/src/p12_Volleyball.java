import java.util.Scanner;

public class p12_Volleyball {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String year = console.nextLine();
        double p = Integer.parseInt(console.nextLine());
        double h = Integer.parseInt(console.nextLine());

        double games = 0;
        double ends = 48 - h;
        ends = ends * 3.0 / 4;
        p = p * 2.0 / 3;
        games = h + p + ends;

        if (year.equals("leap")) {
            games = games + games * 0.15;
        }

        double floor = Math.floor(games);
        System.out.println(floor);

    }

}

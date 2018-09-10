import java.util.Scanner;

public class P05_BonusScore {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int score = Integer.parseInt(console.nextLine());
        double bonusScore = 0;
        double total = 0;

        if (score <= 100) {
            bonusScore = 5;
            total = score + 5;
        } else if (score > 100 && score < 999) {
            bonusScore = (score * 0.2);
            total = score + bonusScore;
        } else if (score > 1000) {
            bonusScore = (score * 0.1);
            total = score + bonusScore;
        }

        if (score % 2 == 0) {
            bonusScore = bonusScore + 1;
            total = total + 1;
        } else if (score % 10 == 5) {
            bonusScore = bonusScore + 2;
            total = total + 2;
        }
        System.out.println(bonusScore);
        System.out.println(total);

    }
}

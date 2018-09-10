import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class p13_1000DaysAfterBirth {
    public static void main(String[] args){

        Scanner console = new Scanner(System.in);
        String dateStr = console.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateStr,dtf);

        date = date.plusDays(999);

        System.out.println(date);


    }
}

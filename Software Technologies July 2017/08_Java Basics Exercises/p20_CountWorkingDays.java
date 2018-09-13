import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class p20_CountWorkingDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        LocalDate[] holidays = new LocalDate[]{
                LocalDate.of(2016, 1, 1),
                LocalDate.of(2016, 3, 3),
                LocalDate.of(2016, 5, 1),
                LocalDate.of(2016, 5, 6),
                LocalDate.of(2016, 5, 24),
                LocalDate.of(2016, 9, 6),
                LocalDate.of(2016, 9, 22),
                LocalDate.of(2016, 11, 1),
                LocalDate.of(2016, 12, 24),
                LocalDate.of(2016, 12, 25),
                LocalDate.of(2016, 12, 26),
        };

        int workingDaysCount = 0;

        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
            LocalDate currentDate = LocalDate.of(2016, date.getMonth(), date.getDayOfMonth());

            if (!Arrays.asList(holidays).contains(currentDate) &&
                    date.getDayOfWeek() != DayOfWeek.SATURDAY &&
                    date.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workingDaysCount++;
            }
        }

        System.out.println(workingDaysCount);

    }
}

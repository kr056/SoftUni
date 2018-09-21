package d_EnumerationsAndAnnotations.Lab.p01_Weekdays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        WeeklyCalendar wc = new WeeklyCalendar();

        wc.addEntry("Friday", "shoot some hoops");
        wc.addEntry("Monday", "BBQ Chicken");
        wc.addEntry("Sunday", "defensive drills");

        Iterable<WeeklyEntry> schedule = wc.getWeeklySchedule();

        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }

    }
}

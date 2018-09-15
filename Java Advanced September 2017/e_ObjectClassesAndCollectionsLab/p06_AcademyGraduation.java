package e_ObjectClassesAndCollectionsLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class p06_AcademyGraduation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, Double> info = new TreeMap<>();

        int studentsCount = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < studentsCount; i++) {
            String name = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double averageGrade = 0.0;

            for (double grade : grades) {
                averageGrade += grade;
            }

            averageGrade = averageGrade / grades.length;
            info.put(name, averageGrade);
        }

        DecimalFormat df = new DecimalFormat("#.################");

        for (String key : info.keySet()) {
            System.out.println(key + " is graduated with " + df.format(info.get(key)));
        }
    }
}

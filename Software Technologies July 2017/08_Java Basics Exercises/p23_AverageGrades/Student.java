package p23_AverageGrades;

import java.util.List;

class Student {
    private String Name;

    String getName() {
        return Name;
    }

    void setName(String name) {
        Name = name;
    }

    private List<Double> Grades;

    void setGrades(List<Double> grades) {
        Grades = grades;
    }

    Double getAverageGrade() {
        double averageGrade = this.Grades.stream().mapToDouble(a -> a).average().
                getAsDouble();

        return this.Grades.stream().mapToDouble(a -> a).average().
                getAsDouble();
    }
}

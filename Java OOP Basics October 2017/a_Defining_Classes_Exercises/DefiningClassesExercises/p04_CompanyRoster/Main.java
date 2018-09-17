package DefiningClassesExercises.p04_CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, List<Employee>> info = new HashMap<>();

        int employeeCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < employeeCount; i++) {
            String[] input = bf.readLine().split("\\s+");
            String name = input[0];
            double salary = Double.valueOf(input[1]);

            String position = input[2];
            String department = input[3];
            String email = "";
            int age = 0;

            Employee employee;

            if (input.length == 5) {
                try {
                    age = Integer.valueOf(input[4]);
                    employee = new Employee(name, salary, position, age);
                } catch (Exception e) {
                    email = input[4];
                    employee = new Employee(name, salary, position, email);
                }
            } else if (input.length == 6) {
                email = input[4];
                age = Integer.valueOf(input[5]);
                employee = new Employee(name, salary, position, email, age);
            } else {
                employee = new Employee(name, salary, position);
            }

            if (!info.containsKey(department)) {
                info.put(department, new ArrayList<>());
            }

            info.get(department).add(employee);
        }

        info.entrySet().stream()
                .sorted((a, b) -> sortByCmd(a, b))
                .limit(1)
                .forEach(s -> printData(s));
    }

    private static void printData(Map.Entry<String, List<Employee>> s) {
        System.out.println("Highest Average Salary: " + s.getKey());

        List<Employee> sortedBySalary = s.getValue().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        for (Employee employee : sortedBySalary) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(),
                    employee.getEmail(), employee.getAge());
        }
    }


    private static int sortByCmd(Map.Entry<String, List<Employee>> a, Map.Entry<String, List<Employee>> b) {
        double departmentOneSalary = a.getValue().stream().mapToDouble(Employee::getSalary).sum();
        double departmentTwoSalary = b.getValue().stream().mapToDouble(Employee::getSalary).sum();

        if (departmentOneSalary > departmentTwoSalary) {
            return -1;
        } else if (departmentOneSalary == departmentTwoSalary) {
            return 0;
        } else {
            return 1;
        }
    }
}

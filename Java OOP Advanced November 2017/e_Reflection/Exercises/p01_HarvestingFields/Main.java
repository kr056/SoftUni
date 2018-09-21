package e_Reflection.Exercises.p01_HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Class myClass = RichSoilLand.class;

        Field[] fields = myClass.getDeclaredFields();

        while (true) {
            String line = bf.readLine();

            if ("HARVEST".equals(line)) {
                break;
            }

            switch (line) {
                case "private":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(f -> System.out.println("private " + f.getType().getSimpleName() + " " + f.getName()));
                    break;
                case "public":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(f -> System.out.println("public " + f.getType().getSimpleName() + " " + f.getName()));
                    break;
                case "protected":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(f -> System.out.println("protected " + f.getType().getSimpleName() + " " + f.getName()));
                    break;
                case "all":
                    Arrays.stream(fields)
                            .forEach(f -> System.out.println(convertModifierToString(f.getModifiers()) + f.getType().getSimpleName() + " " + f.getName()));
                    break;
            }
        }
    }

    private static String convertModifierToString(int modifier) {
        switch (modifier) {
            case 1:
                return "public ";
            case 2:
                return "private ";
            case 4:
                return "protected ";
            default:
                return "";
        }

    }
}

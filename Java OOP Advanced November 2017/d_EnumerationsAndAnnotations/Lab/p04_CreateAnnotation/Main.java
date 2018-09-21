package d_EnumerationsAndAnnotations.Lab.p04_CreateAnnotation;

import java.util.Arrays;

@Subject(categories = {"what's up","randomCategory"})
public class Main {
    public static void main(String[] args) {
        Class c1 = Main.class;
        Subject subject = (Subject) c1.getAnnotation(Subject.class);

        System.out.println(Arrays.toString(subject.categories()));
    }
}

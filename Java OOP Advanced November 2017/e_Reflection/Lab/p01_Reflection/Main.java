package e_Reflection.Lab.p01_Reflection;

import e_Reflection.Lab.Reflection;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Class aClass = Reflection.class;

        System.out.println(aClass);
        System.out.println(aClass.getSuperclass());

        System.out.println(Arrays.toString(aClass.getInterfaces()).replaceAll("[]\\[]", ""));

        Reflection reflection = (Reflection) aClass.newInstance();

        System.out.println(reflection);
    }
}

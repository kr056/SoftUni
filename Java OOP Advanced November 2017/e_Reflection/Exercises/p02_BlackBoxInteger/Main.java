package e_Reflection.Exercises.p02_BlackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Class blackBoxIntClass = BlackBoxInt.class;
        Constructor constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        while (true) {
            String[] tokens = bf.readLine().split("_");

            if ("END".equals(tokens[0])) {
                break;
            }

            Method method = blackBoxIntClass.getDeclaredMethod(tokens[0], int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, Integer.valueOf(tokens[1]));

            Field field = blackBoxIntClass.getDeclaredField("innerValue");
            field.setAccessible(true);

            System.out.println(field.get(blackBoxInt));

        }
    }
}

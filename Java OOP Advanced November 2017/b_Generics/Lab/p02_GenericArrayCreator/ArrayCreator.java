package b_Generics.Lab.p02_GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator<T> {

    public static <T> T[] create(int length, T item) {
        Object[] objects = new Object[length];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = item;
        }

        return (T[]) objects;
    }

    public static <T> T[] create(Class<T> cl, int length, T item) {
        T[] objects = (T[]) Array.newInstance(cl, length);

        for (int i = 0; i < objects.length; i++) {
            objects[i] = item;
        }
        return objects;
    }


}

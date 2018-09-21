package b_Generics.Exercises.p01_GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bang on 19.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Box<String> stringBox = new Box<>();
        int stringCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < stringCount; i++) {
            stringBox.addElement(bf.readLine());
        }

        System.out.println(stringBox.toString());
    }
}

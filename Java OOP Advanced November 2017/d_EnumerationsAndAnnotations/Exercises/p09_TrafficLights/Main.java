package d_EnumerationsAndAnnotations.Exercises.p09_TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] lights = bf.readLine().toUpperCase().split("\\s+");

        int changesCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < changesCount; i++) {
            System.out.println(Arrays.toString(changeLights(lights)).replaceAll("[]\\[,]", ""));
        }
    }

    private static String[] changeLights(String[] lights) {
        for (int i = 0; i < lights.length; i++) {
            if (Light.valueOf(lights[i]).ordinal() == 0) {
                lights[i] = "GREEN";
            } else if (Light.valueOf(lights[i]).ordinal() == 1) {
                lights[i] = "YELLOW";
            } else {
                lights[i] = "RED";
            }
        }

        return lights;
    }
}

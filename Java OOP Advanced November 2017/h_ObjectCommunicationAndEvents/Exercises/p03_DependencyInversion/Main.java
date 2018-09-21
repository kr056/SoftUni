package h_ObjectCommunicationAndEvents.Exercises.p03_DependencyInversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        PrimitiveCalculator primitiveCalculator = new PrimitiveCalculator();

        while (true){
            String[] line = bf.readLine().split("\\s+");

            if("End".equals(line[0])){
                break;
            }

            if("mode".equals(line[0])){
                primitiveCalculator.changeStrategy(line[1]);
            }else {
                System.out.println(primitiveCalculator.executeStrategy(Integer.valueOf(line[0]), Integer.valueOf(line[1])));
            }
        }
    }
}

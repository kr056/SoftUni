package h_FilesAndStreamsExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p02_SumBytes {
    public static void main(String[] args) {
        String path = "D:\\Files-and-Streams\\input.txt";

        long allLinesSum = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line = in.readLine();

            while (line != null) {
                for (char ch : line.toCharArray()) {
                    allLinesSum += ch;
                }

                line = in.readLine();
            }

            System.out.println(allLinesSum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

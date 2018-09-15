package h_FilesAndStreamsExercises;

import java.io.*;

public class p01_SumLines {
    public static void main(String[] args) {

        String path = "D:\\Files-and-Streams\\input.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line = in.readLine();

            while (line != null) {
                long currentLineSum = 0;

                for (char ch : line.toCharArray()) {
                    currentLineSum += ch;
                }

                System.out.println(currentLineSum);
                line = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

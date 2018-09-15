package h_FilesAndStreamsExercises;

import java.io.*;

public class p03_AllCapitals {
    public static void main(String[] args) {

        String path = "D:\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\Files-and-Streams\\allCaps.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(path));
             PrintWriter print = new PrintWriter(new FileWriter(outputPath))) {

            String line = bf.readLine();

            while (line != null) {
                line = line.toUpperCase();
                print.println(line);

                line = bf.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

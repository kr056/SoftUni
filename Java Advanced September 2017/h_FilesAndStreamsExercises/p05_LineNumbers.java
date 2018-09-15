package h_FilesAndStreamsExercises;

import java.io.*;

public class p05_LineNumbers {
    public static void main(String[] args) {

        String path = "D:\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\Files-and-Streams\\lineNumbers.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(path));
             PrintWriter print = new PrintWriter(new FileWriter(outputPath))) {

            int rowCounter = 1;
            String line = bf.readLine();

            while (line != null) {
                print.println(rowCounter + ". " + line);
                line = bf.readLine();
                rowCounter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

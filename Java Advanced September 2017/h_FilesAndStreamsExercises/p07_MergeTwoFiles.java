package h_FilesAndStreamsExercises;

import java.io.*;

public class p07_MergeTwoFiles {
    public static void main(String[] args) {

        String pathOne = "D:\\Files-and-Streams\\wordsOne.txt";
        String pathTwo = "D:\\Files-and-Streams\\wordsTwo.txt";

        String outputPath = "D:\\Files-and-Streams\\mergeResult.txt";

        try (BufferedReader bf1 = new BufferedReader(new FileReader(pathOne));
             BufferedReader bf2 = new BufferedReader(new FileReader(pathTwo));
             PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath))) {

            String lineFileOne = bf1.readLine();

            while (lineFileOne != null) {
                printWriter.println(lineFileOne);
                lineFileOne = bf1.readLine();
            }

            String lineFileTwo = bf2.readLine();

            while (lineFileTwo != null) {
                printWriter.println(lineFileTwo);
                lineFileTwo = bf2.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package h_FilesAndStreamsLab;

import java.io.*;

public class p05_WriteEveryThirdLine {
    public static void main(String[] args) {

        String path = "D:\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\Files-and-Streams\\task5.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(path));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {
            int counter = 1;
            String line = in.readLine();

            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
                line = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package h_FilesAndStreamsLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class p04_ExtractIntegers {
    public static void main(String[] args) {
        String path = "D:\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\Files-and-Streams\\task4.txt";

        try (Scanner scan = new Scanner(new FileInputStream(path));
             PrintWriter out = new PrintWriter(new FileOutputStream(outputPath))
        ) {
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    out.println(scan.nextInt());
                }

                scan.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

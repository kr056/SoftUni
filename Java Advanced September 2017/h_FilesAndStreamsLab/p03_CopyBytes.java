package h_FilesAndStreamsLab;

import java.io.*;

public class p03_CopyBytes {
    public static void main(String[] args) {
        String path = "D:\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\Files-and-Streams\\output3.txt";

        try (InputStream in = new FileInputStream(path);
             OutputStream out = new FileOutputStream(outputPath)) {

            int oneByte = in.read();

            while (oneByte >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }

                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

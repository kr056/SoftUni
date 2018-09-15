package h_FilesAndStreamsLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class p01_ReadAFile {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Files-and-Streams\\input.txt";

        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();

            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

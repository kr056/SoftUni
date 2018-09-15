package h_FilesAndStreamsLab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class p02_WriteToAFile {
    public static void main(String[] args) throws IOException {

        List<Character> punc = new ArrayList<>();
        punc.add('.');
        punc.add('!');
        punc.add('?');
        punc.add(',');

        String path = "D:\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\Files-and-Streams\\output3.txt";

        try (InputStream in = new FileInputStream(path);
             OutputStream out = new FileOutputStream(outputPath)) {
            int oneByte = in.read();

            while (oneByte >= 0) {
                if (!punc.contains((char) oneByte)) {
                    out.write(oneByte);
                }

                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

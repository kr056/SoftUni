package h_FilesAndStreamsLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class p06_SortLines {
    public static void main(String[] args) {

        Path inPath = Paths.get("D:\\Files-and-Streams\\input.txt");
        Path outPath = Paths.get("D:\\Files-and-Streams\\task6.txt");

        try {
            List<String> lines = Files.readAllLines(inPath);
            Collections.sort(lines);
            Files.write(outPath, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

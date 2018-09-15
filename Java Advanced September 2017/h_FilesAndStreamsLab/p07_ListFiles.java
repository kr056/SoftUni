package h_FilesAndStreamsLab;

import java.io.File;

public class p07_ListFiles {
    public static void main(String[] args) {

        File file = new File("D:\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();

                for (File fl : files) {
                    if (!fl.isDirectory()) {
                        System.out.printf("%s: %d\n", fl.getName(), fl.length());
                    }
                }
            }
        }

    }
}

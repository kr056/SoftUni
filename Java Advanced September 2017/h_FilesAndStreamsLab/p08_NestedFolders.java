package h_FilesAndStreamsLab;

import java.io.File;
import java.util.ArrayDeque;

public class p08_NestedFolders {
    public static void main(String[] args) {

        File root = new File("D:\\Files-and-Streams");

        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 1;

        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            for (File fl : current.listFiles()) {
                if (fl.isDirectory()) {
                    dirs.offer(fl);
                    count++;
                }
            }

            System.out.println(current.getName());
        }

        System.out.println(count + " folders");
    }
}

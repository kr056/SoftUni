package h_FilesAndStreamsExercises;

import java.io.File;

public class p08_GetFolderSize {
    public static void main(String[] args) {

        File file = new File("D:\\Files-and-Streams");

        long size = file.length();

        System.out.println(size);
    }
}

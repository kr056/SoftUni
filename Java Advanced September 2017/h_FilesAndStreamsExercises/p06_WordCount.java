package h_FilesAndStreamsExercises;

import java.io.*;
import java.util.HashMap;

public class p06_WordCount {
    public static void main(String[] args) {

        String pathOne = "D:\\Files-and-Streams\\wordsOne.txt";
        String pathTwo = "D:\\Files-and-Streams\\wordsTwo.txt";

        String outputPath = "D:\\Files-and-Streams\\wordsCount.txt";

        HashMap<String, Integer> data = new HashMap<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(pathOne))) {
            String line = bf.readLine();
            while (line != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!data.containsKey(word)) {
                        data.put(word, 0);
                    }
                }
                line = bf.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bf2 = new BufferedReader(new FileReader(pathTwo))) {
            String line = bf2.readLine();
            while (line != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (data.containsKey(word)) {
                        data.put(word, data.get(word) + 1);
                    }
                }
                line = bf2.readLine();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        try (PrintWriter print = new PrintWriter(new FileWriter(outputPath))) {
            data.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .filter(x -> x.getValue() != 0)
                    .forEach(s -> print.println(s.getKey() + " - " + s.getValue()));
        } catch (IOException e3) {
            e3.printStackTrace();
        }

    }
}

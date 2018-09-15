package h_FilesAndStreamsExercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class p04_CountCharacterTypes {
    public static void main(String[] args) {

        String path = "D:\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\Files-and-Streams\\count.txt";

        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        List<Character> punctuation = new ArrayList<>();
        punctuation.add('?');
        punctuation.add('!');
        punctuation.add('.');
        punctuation.add(',');

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        try (BufferedReader bf = new BufferedReader(new FileReader(path));
             PrintWriter print = new PrintWriter(new FileWriter(outputPath))) {
            String line = bf.readLine();

            while (line != null) {
                for (char ch : line.toCharArray()) {
                    if (vowels.contains(ch)) {
                        vowelsCount++;
                    } else if (punctuation.contains(ch)) {
                        punctuationCount++;
                    } else if (ch != ' ') {
                        consonantsCount++;
                    }
                }
                line = bf.readLine();
            }
            print.println("Vowels: " + vowelsCount);
            print.println("Consonants: " + consonantsCount);
            print.println("Punctuation: " + punctuationCount);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

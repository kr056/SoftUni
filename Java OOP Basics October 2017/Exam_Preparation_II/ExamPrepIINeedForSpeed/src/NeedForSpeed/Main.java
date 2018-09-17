package NeedForSpeed;

import NeedForSpeed.IO.InputReader;
import NeedForSpeed.IO.OutputWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader();
        inputReader.readInfo();

        System.out.print(OutputWriter.getAll());
    }
}

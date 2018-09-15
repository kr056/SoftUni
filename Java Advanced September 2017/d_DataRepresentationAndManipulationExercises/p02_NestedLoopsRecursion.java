package d_DataRepresentationAndManipulationExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p02_NestedLoopsRecursion {

    private static int numberOfLoops;
    private static int[] loops;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        numberOfLoops = Integer.parseInt(scan.nextLine());

        loops=new int[numberOfLoops];

        simulateLoops(0);
    }

    private static void simulateLoops(int current) {

        if(current==numberOfLoops){
            printLoop();
            return;
        }

        for (int i = 1;i<=numberOfLoops;i++){
            loops[current]=i;
            simulateLoops(current+1);
        }
    }

    private static void printLoop() {
        System.out.println(Arrays.toString(loops).replaceAll("[]\\[,]",""));
    }
}

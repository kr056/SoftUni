package a_InterfacesAndAbstraction.Exercises.p04_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = bf.readLine().split("\\s+");
        String[] sites = bf.readLine().split("\\s+");

        Smarthphone smarthphone = new Smarthphone();

        for (String num : nums) {
            smarthphone.addNumber(num);
        }

        for (String site : sites) {
            smarthphone.addSite(site);
        }

        System.out.print(smarthphone.call());
        System.out.print(smarthphone.browse());
    }
}

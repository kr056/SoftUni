package DefiningClassesLab.p03_StaticIdAndInterestRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, BankAccount> bank = new HashMap<>();

        while (true) {
            String line = bf.readLine();
            if ("End".equals(line)) {
                break;
            }
            String[] tokens = line.split("\\s+");
            String cmd = tokens[0];

            switch (cmd) {
                case "Create":
                    tryCreateAccount(bank);
                    break;
                case "Deposit":
                    tryDepositingToAccount(tokens, bank);
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.valueOf(tokens[1]));
                    break;
                case "GetInterest":
                    tryGetInterest(tokens, bank);
                    break;
            }
        }


    }

    private static void tryGetInterest(String[] tokens, HashMap<String, BankAccount> bank) {
        String key = "ID" + tokens[1];
        int years = Integer.valueOf(tokens[2]);

        if (bank.containsKey(key)) {
            double interest = bank.get(key).getInterest(years);
            System.out.printf("%.2f\n", interest);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void tryDepositingToAccount(String[] tokens, HashMap<String, BankAccount> bank) {
        String key = "ID" + tokens[1];
        double amount = Double.valueOf(tokens[2]);

        if (bank.containsKey(key)) {
            bank.get(key).deposit(amount);
            System.out.printf("Deposited %.0f to %s\n", amount, bank.get(key));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void tryCreateAccount(HashMap<String, BankAccount> bank) {
        BankAccount acc = new BankAccount();
        bank.put(acc.toString(), acc);
        System.out.println("Account " + acc.toString() + " created");
    }
}

package DefiningClassesLab.p01_BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        while (true) {
            String line = bf.readLine();
            if ("End".equals(line)) {
                break;
            }
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    createAccount(tokens[1], accounts);
                    break;
                case "Deposit":
                    depositMoney(tokens, accounts);
                    break;
                case "Withdraw":
                    withdrawMoney(tokens, accounts);
                    break;
                case "Print":
                    printBalance(tokens, accounts);
                    break;
            }
        }
    }

    private static void printBalance(String[] tokens, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(tokens[1]);

        if (accounts.containsKey(id)) {
            System.out.printf("Account %s, balance %.2f\n", accounts.get(id).toString(), accounts.get(id).balance);
        } else {
            System.out.println("Account does not exist");
        }

    }

    private static void withdrawMoney(String[] tokens, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(tokens[1]);
        double amount = Double.valueOf(tokens[2]);

        if (accounts.containsKey(id)) {
            accounts.get(id).withdraw(amount);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void depositMoney(String[] tokens, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(tokens[1]);
        double amount = Double.valueOf(tokens[2]);

        if (accounts.containsKey(id)) {
            accounts.get(id).deposit(amount);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createAccount(String token, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(token);

        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }

    }
}

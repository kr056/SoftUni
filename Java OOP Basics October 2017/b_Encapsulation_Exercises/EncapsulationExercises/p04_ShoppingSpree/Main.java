package EncapsulationExercises.p04_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] people = bf.readLine().split("[;]");

        LinkedHashMap<String, Person> clients = new LinkedHashMap<>();
        LinkedHashMap<String, Product> shop = new LinkedHashMap<>();

        for (String person : people) {
            String[] tokens = person.split("=");
            String name = tokens[0];
            double money = Double.valueOf(tokens[1]);

            try {
                Person newPerson = new Person(name, money);
                clients.put(newPerson.getName(), newPerson);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] products = bf.readLine().split("[;]");

        for (String p : products) {
            String[] tokens = p.split("[=]");
            String productName = tokens[0];
            double price = Double.valueOf(tokens[1]);

            try {
                Product product = new Product(productName, price);
                shop.put(product.getName(), product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        while (true) {
            String line = bf.readLine();

            if ("END".equals(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");

            clients.get(tokens[0]).addProduct(shop.get(tokens[1]));
        }

        for (String key : clients.keySet()) {
            clients.get(key).printPersonProductBag();
        }

    }
}

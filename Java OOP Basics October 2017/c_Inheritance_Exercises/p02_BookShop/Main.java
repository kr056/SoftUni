package c_Inheritance_Exercises.p02_BookShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            try {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

                String author = bf.readLine();
                String title = bf.readLine();
                double price = Double.valueOf(bf.readLine());

                Book book = new Book(author, title, price);
                GoldenEditionBook goldenEditionBook = new GoldenEditionBook(author, title, price);

                System.out.println(book.toString());
                System.out.println(goldenEditionBook.toString());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Title not valid!");
        }

    }
}

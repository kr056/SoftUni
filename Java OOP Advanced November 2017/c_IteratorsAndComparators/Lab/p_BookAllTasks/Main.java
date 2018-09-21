package c_IteratorsAndComparators.Lab.p_BookAllTasks;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);

        //Task 1
        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        //Task 2
        Library library = new Library(bookOne, bookTwo, bookThree);

        for (c_IteratorsAndComparators.Lab.p_BookAllTasks.Book book : library) {
            System.out.println(book.getAuthors());
        }

        System.out.println();

        // Task 3
        if (bookOne.compareTo(bookTwo) < 0) {
            System.out.println(String.format("%s is before %s", bookOne.getTitle(), bookTwo.getTitle()));
        } else if (bookOne.compareTo(bookTwo) > 0) {
            System.out.println(String.format("%s is before %s", bookTwo.getTitle(), bookOne.getTitle()));
        } else {
            System.out.println("c_IteratorsAndComparators.Lab.p_BookAllTasks.Book are equal");
        }

        System.out.println();
        //Task 4
        books.sort(new BookComparator());

        for (Book book : books) {
            System.out.println(book.getTitle() + " " + book.getYear());
        }

    }
}

package p24_bookLibrary;

import java.util.ArrayList;

public class BookLibrary {
    private String name;
    private ArrayList<Book> books;


    void setName(String name) {
        this.name = name;
    }

    ArrayList<Book> getBooks() {
        return books;
    }

    void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}

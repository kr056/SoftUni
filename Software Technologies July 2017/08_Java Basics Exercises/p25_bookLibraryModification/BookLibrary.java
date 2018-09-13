package p25_bookLibraryModification;


import java.util.ArrayList;

public class BookLibrary {
    private String name;
    private ArrayList<Book> books;

    void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}

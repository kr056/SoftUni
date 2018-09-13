package p25_bookLibraryModification;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private LocalDate releaseDate;
    private String isbn;
    private Double price;

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    LocalDate getReleaseDate() {
        return releaseDate;
    }

    void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    void setPrice(Double price) {
        this.price = price;
    }
}
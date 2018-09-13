package p24_bookLibrary;

import java.time.LocalDate;

class Book {
    private String title;
    private String author;
    private String publisher;
    private LocalDate releaseDate;
    private String isbn;
    private Double price;


    void setTitle(String title) {
        this.title = title;
    }

    String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    Double getPrice() {
        return price;
    }

    void setPrice(Double price) {
        this.price = price;
    }
}

package p25_bookLibraryModification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BookLibrary library = new BookLibrary() {{
            setName("Prosveta");
            setBooks(new ArrayList<>());
        }};


        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        int booksCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < booksCount; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            Book book = new Book() {{
                setTitle(tokens[0]);
                setAuthor(tokens[1]);
                setPublisher(tokens[2]);
                setReleaseDate(LocalDate.parse(tokens[3], df));
                setIsbn(tokens[4]);
                setPrice(Double.parseDouble(tokens[5]));

            }};

            library.getBooks().add(book);
        }

        LocalDate minReleaseDate = LocalDate.parse(
                scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        Book[] sortedBooks = library.getBooks().stream()
                .filter(a -> a.getReleaseDate().isAfter(minReleaseDate))
                .sorted((a, b) -> {
                    int compareResult = a.getReleaseDate().compareTo(b.getReleaseDate());

                    if (compareResult == 0) {
                        compareResult = a.getTitle().compareTo(b.getTitle());
                    }

                    return compareResult;
                })
                .toArray(Book[]::new);

        for (Book book : sortedBooks) {
            System.out.printf("%s -> %s%n", book.getTitle(), df.format(book.getReleaseDate()));
        }
    }
}




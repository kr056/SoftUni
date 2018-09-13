package p24_bookLibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        library.getBooks().stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.summingDouble(Book::getPrice)))
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int comparisonRes = Double.compare(b.getValue(), a.getValue());

                    if (comparisonRes == 0) {
                        comparisonRes = a.getKey().compareTo(b.getKey());
                    }

                    return comparisonRes;
                })
                .forEach((kvp) -> {
                    String author = kvp.getKey();
                    double totalSum = kvp.getValue();
                    System.out.printf("%s -> %.2f%n", author, totalSum);
                });
    }
}

package c_Inheritance_Exercises.p02_BookShop;

public class Book {
    private String author;
    private String title;
    private double price;

    Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    void setAuthor(String author) {
        author = author.replaceAll("\\s+", " ");
        if (author.contains(" ") && Character.isDigit((author.charAt(author.indexOf(" ") + 1)))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }


    void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }


    void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    String getAuthor() {
        return author;
    }

    String getTitle() {
        return title;
    }

    double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName()).append("\n");
        sb.append("Title: ").append(this.getTitle()).append("\n");
        sb.append("Author: ").append(this.getAuthor()).append("\n");
        sb.append("Price: ").append(String.format("%.1f", this.getPrice())).append("\n");

        return sb.toString();
    }
}

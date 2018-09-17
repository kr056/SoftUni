package c_Inheritance_Exercises.p02_BookShop;

class GoldenEditionBook extends Book {

    GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }
}

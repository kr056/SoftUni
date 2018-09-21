package f_OpenClosedLiskovSubstitutionPrinciples.Lab.p05_Square;

import org.junit.Assert;
import org.junit.Test;


public class RectangleTests {
    @Test
    public void getSidesTest() {
        Rectangle rect = new Rectangle(10, 5);
        Assert.assertEquals(10, rect.getWidth());
        Assert.assertEquals(5, rect.getHeight());
    }

    @Test
    public void getAreaTest() {
        Rectangle rect = new Rectangle(5, 10);
        Assert.assertEquals(50, rect.getArea());
    }

    @Test
    public void getSquareAreaTest() {
        Rectangle square = new Square(5);
        Assert.assertEquals(25, square.getArea());
    }

    @Test
    public void getSquareSidesTest() {
        Rectangle square = new Square(5);
        Assert.assertEquals(5, square.getWidth());
        Assert.assertEquals(5, square.getHeight());
    }
}

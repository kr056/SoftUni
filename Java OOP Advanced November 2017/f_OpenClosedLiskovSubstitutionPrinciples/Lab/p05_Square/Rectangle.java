package f_OpenClosedLiskovSubstitutionPrinciples.Lab.p05_Square;

public class Rectangle {
    private int m_width;
    private int m_height;

    public Rectangle(int m_width, int m_height) {
        this.setWidth(m_width);
        this.setHeight(m_height);
    }

    public Rectangle(int m_width) {
        this.setWidth(m_width);
        this.setHeight(m_width);
    }

    public void setWidth(int m_width) {
        this.m_width = m_width;
    }

    public void setHeight(int m_height) {
        this.m_height = m_height;
    }

    public int getWidth() {
        return m_width;
    }

    public int getHeight() {
        return m_height;
    }

    public int getArea() {
        return m_width * m_height;
    }
}

package f_OpenClosedLiskovSubstitutionPrinciples.Lab.p03_GraphicEditor;

public class Main {
    public static void main(String[] args) {
        Drawable circle = new Circle();
        circle.draw();

        Drawable rectangle = new Rectangle();

        GraphicEditor graphicEditor = new GraphicEditor(rectangle);
        graphicEditor.drawWithEditor();
    }
}

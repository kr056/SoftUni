package f_OpenClosedLiskovSubstitutionPrinciples.Lab.p03_GraphicEditor;

public class GraphicEditor {
    private Drawable drawable;

    public GraphicEditor(Drawable drawable) {
        this.drawable = drawable;
    }

    void drawWithEditor() {
        this.drawable.draw();
    }

}

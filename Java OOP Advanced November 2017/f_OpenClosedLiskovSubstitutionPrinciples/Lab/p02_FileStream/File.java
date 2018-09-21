package f_OpenClosedLiskovSubstitutionPrinciples.Lab.p02_FileStream;

public class File implements Streamable {

    private String name;
    private int length;
    private int bytesSent;

    public File(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    public int getLength() {
        return this.length;
    }

    public int getBytesSent() {
        return this.bytesSent;
    }
}

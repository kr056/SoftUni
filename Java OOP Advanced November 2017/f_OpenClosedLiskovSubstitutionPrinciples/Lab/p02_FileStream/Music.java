package f_OpenClosedLiskovSubstitutionPrinciples.Lab.p02_FileStream;

public class Music implements Streamable {

    private String artist;
    private String album;
    private int length;
    private int bytesSent;

    public Music(int length, int bytesSent) {
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

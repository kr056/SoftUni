package NeedForSpeed.IO;

public class OutputWriter {
    private static StringBuilder all = new StringBuilder();

    public static void gatherAllForPrint(String info) {
        OutputWriter.all.append(info);
    }

    public static StringBuilder getAll() {
        return all;
    }
}

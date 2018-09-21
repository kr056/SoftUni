package g_ISPandDIP.Lab.p01_SystemResources;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String string) {
        System.out.println(string);
    }
}

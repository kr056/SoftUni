import java.util.Scanner;

public class p16_URLParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String url = scanner.nextLine();
        String protocol = "";
        String server = "";
        String resource = "";

        if (url.indexOf("://") != -1) {
            protocol = url.substring(0, url.indexOf(':'));
            url = url.substring(url.indexOf("/") + 2);

            if (url.indexOf('/') != -1) {
                server = url.substring(0, url.indexOf('/'));
                resource = url.substring(url.indexOf('/') + 1);
            } else {
                server = url;
            }
        } else {

            if (url.indexOf('/') != -1) {
                server = url.substring(0, url.indexOf('/'));
                resource = url.substring(url.indexOf('/') + 1);
            } else {
                server = url;
            }
        }

        System.out.printf("[protocol] = \"%s\"%n", protocol);
        System.out.printf("[server] = \"%s\"%n", server);
        System.out.printf("[resource] = \"%s\"%n", resource);

    }
}

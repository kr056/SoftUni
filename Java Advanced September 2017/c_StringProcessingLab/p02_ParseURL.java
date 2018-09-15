package c_StringProcessingLab;

import java.util.Scanner;

public class p02_ParseURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] url = scanner.nextLine().split("://");

        if (url.length != 2) {
            System.out.printf("Invalid URL");
            return;
        }

        String protocol = url[0];

        int indexOfServerEnd = url[1].indexOf("/");

        if (indexOfServerEnd < 0) {
            System.out.println("Invalid URL");
            return;
        }

        String server = url[1].substring(0, indexOfServerEnd);

        String resources = "";

        if (indexOfServerEnd != url[1].length() - 1) {
            resources = url[1].substring(indexOfServerEnd + 1);
        }

        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resources);

    }
}

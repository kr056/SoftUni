package e_ObjectClassesAndCollectionsLab;

import java.util.*;

public class p05_SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> vips = new HashSet<>();
        Set<String> regs = new TreeSet<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("PARTY")) {
                break;
            }

            if (Character.isDigit(input.charAt(0))) {
                vips.add(input);
            } else {
                regs.add(input);
            }
        }

        while (true) {
            String guestComing = scan.nextLine();

            if (guestComing.equals("END")) {
                break;
            }

            if (Character.isDigit(guestComing.charAt(0))) {
                vips.remove(guestComing);
            } else {
                regs.remove(guestComing);
            }
        }

        regs.addAll(vips);

        System.out.println(regs.size());

        for (String reg : regs) {
            System.out.println(reg);
        }
    }
}

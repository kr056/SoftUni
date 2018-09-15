package g_BuiltInQueryMethodsStreamAPILab;

import java.util.*;

public class p01_TakeTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.asList(scanner.nextLine().split("\\s+"));

        List<Integer> nums = new ArrayList<>();

        for (String str : input) {
            nums.add(Integer.parseInt(str));
        }

        nums.stream()
                .filter(x -> 10 <= x && x <= 20)
                .distinct()
                .limit(2)
                .forEach(n -> System.out.print(n + " "));
    }
}

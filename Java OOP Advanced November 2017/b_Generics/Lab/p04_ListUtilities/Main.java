package b_Generics.Lab.p04_ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums,11,12,13,14,15);

        System.out.println(ListUtils.getMin(nums));
        System.out.println(ListUtils.getMax(nums));
    }
}

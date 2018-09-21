package b_Generics.Lab.p05_NullFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums,11,12,13,null,null);

        System.out.println(ListUtils.getNullIndices(nums));
    }
}

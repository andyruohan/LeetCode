package Algorithm_I.Day12.problem120;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        triangle.add(a1);
        List<Integer> a2 = new ArrayList<>();
        a2.add(3);
        a2.add(4);
        triangle.add(a2);
        System.out.println(minimumTotal(triangle));
    }
}

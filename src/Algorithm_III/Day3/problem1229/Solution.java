package Algorithm_III.Day3.problem1229;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < slots1.length; i++) {
            for (int j = 0; j < slots2.length; j++) {
                if (slots1[i][0] >= slots2[j][0] && slots1[i][1] <= slots2[j][1]) {
                    if (slots1[i][1] - slots1[i][0] >= duration) {
                        result.add(slots1[i][0]);
                        result.add(slots1[i][0] + duration);
                        return result;
                    }
                    continue;
                } else if (slots2[j][0] >= slots1[i][0] && slots2[j][1] <= slots1[i][1]) {
                    if (slots2[j][1] - slots2[j][0] >= duration) {
                        result.add(slots2[j][0]);
                        result.add(slots2[j][0] + duration);
                        return result;
                    }
                    continue;
                } else if (slots1[i][1] >= slots2[j][0] && slots1[i][1] - slots2[j][0] >= duration
                        && slots2[j][1] >= slots1[i][0] && slots2[j][1] - slots1[i][0] >= duration) {
                    if (slots1[i][1] - slots2[j][0] < slots2[j][1] - slots1[i][0]) {
                        result.add(slots2[j][0]);
                        result.add(slots2[j][0] + duration);
                        return result;
                    } else {
                        result.add(slots1[i][0]);
                        result.add(slots1[i][0] + duration);
                        return result;
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minAvailableDuration(new int[][]{{10, 50}, {60, 120}, {140, 210}}, new int[][]{{0, 15}, {60, 70}}, 8));
//        System.out.println(solution.minAvailableDuration(new int[][]{{0, 20}}, new int[][]{{1, 2}, {4, 30}}, 4));
    }
}

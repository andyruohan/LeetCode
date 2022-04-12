package Algorithm_III.Day3.problem1229;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < slots1.length; i++) {
            for (int j = 0; j < slots2.length; j++) {
                if (slots1[i][0] > min || slots2[j][0] > min) {
                    continue;
                }

                if (slots1[i][0] >= slots2[j][0] && slots1[i][1] <= slots2[j][1]) {
                    if (slots1[i][1] - slots1[i][0] >= duration) {
                        if (min > slots1[i][0]) {
                            min = slots1[i][0];
                        }
                    }
                } else if (slots2[j][0] >= slots1[i][0] && slots2[j][1] <= slots1[i][1]) {
                    if (slots2[j][1] - slots2[j][0] >= duration) {
                        if (min > slots2[j][0]) {
                            min = slots2[j][0];
                        }
                    }
                } else if (slots1[i][1] >= slots2[j][0] && slots1[i][1] - slots2[j][0] >= duration
                        && slots2[j][1] >= slots1[i][0] && slots2[j][1] - slots1[i][0] >= duration) {
                    if (slots1[i][1] - slots2[j][0] < slots2[j][1] - slots1[i][0]) {
                        if (min > slots2[j][0]) {
                            min = slots2[j][0];
                        }
                    } else {
                        if (min > slots1[i][0]) {
                            min = slots1[i][0];
                        }
                    }
                }
            }
        }
        if (min != Integer.MAX_VALUE) {
            result.add(min);
            result.add(min + duration);
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.minAvailableDuration(new int[][]{{10, 50}, {60, 120}, {140, 210}}, new int[][]{{0, 15}, {60, 70}}, 8));
//        System.out.println(solution.minAvailableDuration(new int[][]{{0, 20}}, new int[][]{{1, 2}, {4, 30}}, 4));
        System.out.println(solution.minAvailableDuration(new int[][]{{216397070,363167701},{98730764,158208909},{441003187,466254040},{558239978,678368334},{683942980,717766451}}, new int[][]{{50490609,222653186},{512711631,670791418},{730229023,802410205},{812553104,891266775},{230032010,399152578}}, 456085));
    }
}

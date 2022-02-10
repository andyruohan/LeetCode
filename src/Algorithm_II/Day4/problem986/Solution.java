package Algorithm_II.Day4.problem986;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result =  new ArrayList<>();

        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);

            if (low <= high) {
                result.add(new int[] {low, high});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(intervalIntersection(new int[][]{{0, 2}}, new int[][] {{1, 5}}));
    }
}

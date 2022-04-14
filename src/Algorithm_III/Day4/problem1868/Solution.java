package Algorithm_III.Day4.problem1868;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> RunLengthCodingArray = new ArrayList<>();
        int index = 0;
        for (int i = 0, j = 0; i < encoded1.length && j < encoded2.length;) {
            List<Integer> RunLengthCoding = new ArrayList<>();
            int value = encoded1[i][0] * encoded2[j][0];
            if (encoded1[i][1] >= encoded2[j][1]) {
                if (index != 0 && RunLengthCodingArray.get(index - 1).get(0) == value) {
                    RunLengthCodingArray.get(index - 1).set(1, RunLengthCodingArray.get(index - 1).get(1) + encoded2[j][1]);
                } else {
                    RunLengthCoding.add(value);
                    RunLengthCoding.add(encoded2[j][1]);
                }
                encoded1[i][1] -= encoded2[j][1];
                if (encoded1[i][1] == 0) {
                    i++;
                }
                j++;
            } else {
                if (index != 0 && RunLengthCodingArray.get(index - 1).get(0) == value) {
                    RunLengthCodingArray.get(index - 1).set(1, RunLengthCodingArray.get(index - 1).get(1) + encoded1[i][1]);
                } else {
                    RunLengthCoding.add(value);
                    RunLengthCoding.add(encoded1[i][1]);
                }
                encoded2[j][1] -= encoded1[i][1];
                if (encoded2[j][1] == 0) {
                    j++;
                }
                i++;
            }
            if (!RunLengthCoding.isEmpty()) {
                RunLengthCodingArray.add(RunLengthCoding);
                index++;
            }
        }
        return RunLengthCodingArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findRLEArray(new int[][]{{1, 3}, {2, 3}}, new int[][]{{6, 3}, {3, 3}}));
        System.out.println(solution.findRLEArray(new int[][]{{5,2},{3,5},{5,4},{2,5},{3,4},{4,5},{1,2},{2,1},{3,1},{5,5}}, new int[][]{{2,5},{1,1},{2,1},{1,3},{5,2},{3,4},{2,5},{5,5},{4,2},{2,1},{1,4},{3,1}}));

    }
}

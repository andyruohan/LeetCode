package Algorithm_III.Day2.problem1182;

import util.ConvertUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            if (hashMap.get(colors[i]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(colors[i], list);
            } else {
                hashMap.get(colors[i]).add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(binaryFind(hashMap, query));
        }
        return result;
    }

    private int binaryFind(HashMap<Integer, List<Integer>> hashMap, int[] query) {
        if (hashMap.get(query[1]) == null) {
            return -1;
        }

        List<Integer> colorList = hashMap.get(query[1]);
        int index = query[0], left = 0, right = colorList.size() - 1;
        while (left <= right) {
            if (index < colorList.get(left)) {
                if (left - 1 >= 0) {
                    return Math.min(Math.abs(colorList.get(left)- index), Math.abs(colorList.get(left - 1) - index));
                } else {
                    return Math.abs(colorList.get(left) - index);
                }
            } else if (index > colorList.get(right)) {
                if (right + 1 < colorList.size()) {
                    return Math.min(Math.abs(colorList.get(right)- index), Math.abs(colorList.get(right + 1) - index));
                } else {
                    return Math.abs(colorList.get(right)- index);
                }
            }

            int middle = (left + right) / 2;
            int middleIndex = colorList.get(middle);
            if (middleIndex <= index && index <= middleIndex + 1) {
                if (index == middleIndex) {
                    return 0;
                } else {
                    return Math.min(Math.abs(middleIndex - index), Math.abs(colorList.get(middle + 1) - index));
                }
            } else if (index < middleIndex) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.shortestDistanceColor(new int[]{1, 1, 2, 1, 3, 2, 2, 3, 3}, new int[][]{{1, 3}, {2, 2}, {6, 1}}));
//        System.out.println(solution.shortestDistanceColor(new int[]{2,1,2,2,1}, new int[][]{{1,1}, {4,3}, {1,3}, {4,2}, {2,1}}));
//        System.out.println(solution.shortestDistanceColor(new int[]{3,2,2,1,3,1,1,1,3,1}, new int[][]{{4,1},{9,2},{4,2},{8,1},{0,3},{2,1},{2,3},{6,3},{4,1},{1,2}}));
        System.out.println(solution.shortestDistanceColor(new int[]{3,1,1,2,3,3,2,1,2,3,1,1,3,2,3,1,1,1,1,2,2,1,2,2,2,1,1,1,1,2,3,3,3,1,3,2,1,1,2,2,1,3,1,2,1,1,2,2,1,2}, new int[][]{{10,2},{0,1},{32,3},{1,1},{41,1},{48,3},{0,3},{46,2},{48,2},{28,1},{47,2},{11,2},{49,3},{3,3},{40,1},{1,2},{42,2},{47,2},{36,3},{23,1},{7,3},{47,2},{13,3},{36,1},{17,2},{46,2},{38,2},{0,1},{38,3},{36,3},{33,1},{11,3},{39,2},{10,2},{44,3},{5,1},{36,3},{44,3},{38,1},{9,1},{9,1},{35,3},{10,1},{9,1},{0,3},{1,1},{0,3},{28,1},{22,3},{15,1}}));
//        System.out.println(ConvertUtil.squareBracketsToBrace("[3,1,1,2,3,3,2,1,2,3,1,1,3,2,3,1,1,1,1,2,2,1,2,2,2,1,1,1,1,2,3,3,3,1,3,2,1,1,2,2,1,3,1,2,1,1,2,2,1,2]\n" +
//                "[[10,2],[0,1],[32,3],[1,1],[41,1],[48,3],[0,3],[46,2],[48,2],[28,1],[47,2],[11,2],[49,3],[3,3],[40,1],[1,2],[42,2],[47,2],[36,3],[23,1],[7,3],[47,2],[13,3],[36,1],[17,2],[46,2],[38,2],[0,1],[38,3],[36,3],[33,1],[11,3],[39,2],[10,2],[44,3],[5,1],[36,3],[44,3],[38,1],[9,1],[9,1],[35,3],[10,1],[9,1],[0,3],[1,1],[0,3],[28,1],[22,3],[15,1]]"));
    }
}


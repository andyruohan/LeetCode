package Algorithm_III.Day2.problem1182;

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
                return Math.abs(colorList.get(left) - index);
            } else if (index > colorList.get(right)) {
                return Math.abs(colorList.get(right)- index);
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
    }
}


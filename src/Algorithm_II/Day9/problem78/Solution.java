package Algorithm_II.Day9.problem78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static int length;
    public static List<List<Integer>> subsets(int[] nums) {
        length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
//        result.add(new ArrayList<>() {});
        dfs(nums, result, 0);
        return result;
    }

    public static void dfs(int [] nums, List<List<Integer>> lists, int n) {
        if (n == length) {
            return;
        }

        int curLength = lists.size();
        for (int i = 0; i < curLength; i++) {
            List<Integer> curList = new ArrayList<>(lists.get(i));
            curList.add(nums[n]);
            lists.add(curList);
        }

        dfs(nums, lists, ++n);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1, 2, 3}));
    }
}

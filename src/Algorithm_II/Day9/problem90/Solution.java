package Algorithm_II.Day9.problem90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static int length;
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>() {});
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
            if (!lists.contains(curList)) {
                lists.add(curList);
            }
        }

        dfs(nums, lists, ++n);
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {4, 4, 4, 1, 4}));
    }
}

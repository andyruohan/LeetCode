package problem18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        int length = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < length - 1; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int low = j + 1; int high = length - 1; int sum = target - nums[i] - nums[j];
                        while (low < high) {
                            if (nums[low] + nums[high] == sum) {
                                resultList.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while (low < high && nums[low] == nums[low + 1]) {low++;}
                                while (low < high && nums[high] == nums[high - 1]) {high--;}
                                low++; high--;
                            } else if (nums[low] + nums[high] < sum) {
                                low++;
                            } else {
                                high--;
                            }
                        }
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
    }
}

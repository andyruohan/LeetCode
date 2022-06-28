package Algorithm_III.Day15.problem315;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[] index;
    private int[] temp;
    private int[] ans;
    private int length;

    public List<Integer> countSmaller(int[] nums) {
        length = nums.length;
        index = new int[length];
        temp = new int[length];
        ans = new int[length];
        for (int i = 0; i < length; i++) {
            index[i] = i;
        }
        int left = 0, right = length - 1;
        mergeSort(nums, left, right);
        List<Integer> list = new ArrayList<>();
        for (int num : ans) {
            list.add(num);
        }
        return list;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = index[i];
        }
        
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                index[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                index[k] = temp[i];
                i++;
                ans[index[k]] += right - mid;
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                index[k] = temp[i];
                i++;
                ans[index[k]] += j - mid - 1;
            } else {
                index[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.countSmaller(new int[] {5,2,6,1}));
        System.out.println(solution.countSmaller(new int[] {-1, -1}));
    }
}

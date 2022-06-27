package Algorithm_III.Day15.problem315;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[] index;
    private int[] temp;
    private int[] tempIndex;
    private int[] ans;
    private int length;

    public List<Integer> countSmaller(int[] nums) {
        length = nums.length;
        index = new int[length];
        temp = new int[length];
        tempIndex = new int[length];
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
        int i = left, j = mid + 1, p = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[p] = nums[i];
                tempIndex[p] = index[i];
                ans[index[i]] += (j - mid - 1);
                ++i;
                ++p;
            } else {
                temp[p] = nums[j];
                tempIndex[p] = index[j];
                ++j;
                ++p;
            }
        }
        while (i <= mid) {
            temp[p] = nums[i];
            tempIndex[p] = index[i];
            ans[index[i]] += (j - mid -1);
            ++i;
            ++p;
        }
        while (j <= right) {
            temp[p] = nums[j];
            tempIndex[p] = index[j];
            ++j;
            ++p;
        }
        for (int k = left; k <= right; k++) {
            index[k] = tempIndex[k];
            nums[k] = temp[k];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSmaller(new int[] {5,2,6,1}));
    }
}

package Algorithm_I.Day3.problem167;

import java.util.HashMap;

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(target - numbers[i])) {
                return new int[] {hashMap.get(target - numbers[i]) + 1, i + 1};
            }
            hashMap.put(numbers[i], i);
        }
        return new int[] {-1, -1};
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum;
        while(left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[] {2,7,11,15}, 9));
    }
}

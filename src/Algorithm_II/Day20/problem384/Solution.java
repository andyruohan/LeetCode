package Algorithm_II.Day20.problem384;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    int[] originalNums;
    int[] copyNums;

    public Solution(int[] nums) {
        originalNums = nums;
    }

    public int[] reset() {
        return originalNums;
    }

    public int[] shuffle() {
        copyNums = Arrays.copyOf(originalNums, originalNums.length);
        int length = copyNums.length;
        Random rd = new Random();
        for (int i = 0; i < length; i++) {
            int j = rd.nextInt(length);
            int temp = copyNums[i];
            copyNums[i] = copyNums[j];
            copyNums[j] = temp;
        }
        return copyNums;
    }
}

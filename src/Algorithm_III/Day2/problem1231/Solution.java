package Algorithm_III.Day2.problem1231;

import java.util.stream.IntStream;

public class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int sumSweetness = IntStream.of(sweetness).sum();

        int left = 0, right = sumSweetness / (k + 1);
        int maximizeMinSweetness = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (check(sweetness, middle, k)) {
                maximizeMinSweetness = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return maximizeMinSweetness;
    }

    private boolean check(int[] sweetness, int sum, int k) {
        int currentSum = 0, num = 0;
        for (int i = 0; i < sweetness.length; i++) {
            currentSum += sweetness[i];
            if (currentSum >= sum) {
                currentSum = 0;
                num++;
            }
        }
        return num >= k + 1;
    }
}

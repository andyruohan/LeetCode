package problem4;

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int [] temp = nums1;
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;
        int left = 0;
        int right = m;

        while ((left < right)) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int leftNum1Max = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int rightNum1Min = i == m ? Integer.MAX_VALUE : nums1[i];
        int leftNum2Max = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int rightNum2Min = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 1) {
            return Math.max(leftNum1Max, leftNum2Max);
        } else {
            return  (Math.max(leftNum1Max, leftNum2Max) + Math.min(rightNum1Min, rightNum2Min)) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {3};
        int[] num2 = {-2, -1};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}

package Algorithm_I.Day3.problem283;

public class Solution {
	public static void moveZeroes(int[] nums) {
		int nonZeroNums = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				while (i + 1 < n && nums[i + 1] == 0) {
					i++;
				}
			} else {
				nums[nonZeroNums] = nums[i];
				nonZeroNums++;
			}
		}


		for (int j = nonZeroNums; j < n; j++) {
			nums[j] = 0;
		}
	}

	public static void moveZeroes2(int[] nums) {
		int slow = 0, fast = 1;
		while (fast < nums.length) {
			if (nums[slow] == nums[fast]) {
				fast++;
			} else if (nums[slow] != nums[fast]) {
				if (nums[slow] == 0) {
					int temp = nums[slow];
					nums[slow] = nums[fast];
					nums[fast] = temp;
				}
				slow++;
				fast++;
			}
		}
	}

	public static void moveZeroes3(int[] nums) {
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != 0) {
				//奇怪，此处将if判断条件去掉，反而执行用例越快
                if (nums[slow] != nums[fast]) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }

				slow++;
			}
			fast++;
		}
	}

	public static void main(String[] args) {
		moveZeroes3(new int[]{0, 1, 0, 3, 12});
	}
}

package problem1;

import java.util.HashMap;

/**
 * @author andy_ruohan
 * @description 两数之和
 * @date 2025/1/6 22:02
 */
class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(nums[i])) {
				return new int[] {hashMap.get(nums[i]), i};
			}
			hashMap.put(target - nums[i], i);
		}
		return new int[] {0, 0};
	}
}

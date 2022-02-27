package Algorithm_II.Day13.problem45;

public class Solution {
    public int jump(int[] nums) {
        int n = nums.length - 1, right = 0, rightmost = 0, step = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]); // 已遍历数组，预计能到的最远距离
                if (i == right) { // 如果已经到当前步数能到的最远距离
                    step++; // 步数+1 (还能进入本次循环if条件，证明还需要往下走)
                    right = rightmost; // 更新最远距离
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[] {2,3,1,1,4}));
    }
}

package Algorithm_III.Day17.problem337;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int rob(TreeNode root) {
        int[] robStatus = dfs(root);
        return Math.max(robStatus[0], robStatus[1]);
    }

    public int[] dfs(TreeNode treeNode) {
        if (null == treeNode) {
            return new int[] {0, 0};
        }

        int[] left = dfs(treeNode.left);
        int[] right = dfs(treeNode.right);
        int selected = treeNode.val + left[1] + right[1];
        int unselected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {selected, unselected};
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
        TreeNode root = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3));
        Solution solution = new Solution();
        System.out.println(solution.rob(root));
    }
}

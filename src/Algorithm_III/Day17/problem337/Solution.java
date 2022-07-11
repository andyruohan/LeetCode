package Algorithm_III.Day17.problem337;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        int[] dp = new int[14];
        dp[1] = root.val;
        while (!queue.isEmpty()) {
            depth++;
            int count = 0;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode curNode = queue.poll();
                count += curNode.val;
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            if (depth > 1) {
                dp[depth] = Math.max(dp[depth - 2] + count, dp[depth - 1]);
            }
        }

        return dp[depth];
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
        TreeNode root = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3));
        Solution solution = new Solution();
        System.out.println(solution.rob(root));
    }
}

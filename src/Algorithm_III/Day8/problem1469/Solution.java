package Algorithm_III.Day8.problem1469;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> resList = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        dfs(root);
        return resList;
    }

    private void dfs(TreeNode root) {
        if (root.left == null && root.right != null) {
            resList.add(root.right.val);
        }
        if (root.left != null && root.right == null) {
            resList.add(root.left.val);
        }

        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode listNode = new TreeNode(7, new TreeNode(1, new TreeNode(6), null), new TreeNode(4, new TreeNode(5), new TreeNode(3, null, new TreeNode(2))));
        Solution solution = new Solution();
        System.out.println(solution.getLonelyNodes(listNode));
    }
}

package Algorithm_III.Day8.problem1469;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    List<Integer> resList = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return resList;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null && treeNode.right == null) {
                resList.add(treeNode.left.val);
                queue.add(treeNode.left);
            } else if (treeNode.left == null && treeNode.right != null) {
                resList.add(treeNode.right.val);
                queue.add(treeNode.right);
            } else if (treeNode.left != null && treeNode.right != null) {
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        TreeNode listNode = new TreeNode(7, new TreeNode(1, new TreeNode(6), null), new TreeNode(4, new TreeNode(5), new TreeNode(3, null, new TreeNode(2))));
        Solution solution = new Solution();
        System.out.println(solution.getLonelyNodes(listNode));
    }
}

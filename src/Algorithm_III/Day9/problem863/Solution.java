package Algorithm_III.Day9.problem863;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer, TreeNode> parentMap = new HashMap<>();
    List<Integer> resList = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        getParentNode(root);
        getResNode(target, null, 0, k);
        return resList;
    }

    private void getParentNode(TreeNode root) {
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            getParentNode(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            getParentNode(root.right);
        }
    }

    private void getResNode(TreeNode node, TreeNode form, int distance, int k) {
        if (node == null) {
            return;
        }

        if (distance == k) {
            resList.add(node.val);
            return;
        }

        if (node.left != form) {
            getResNode(node.left, node, distance + 1, k);
        }

        if (node.right != form) {
            getResNode(node.right, node, distance + 1, k);
        }

        if (parentMap.get(node.val) != form) {
            getResNode(parentMap.get(node.val), node, distance + 1, k);
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(2);
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        Solution solution = new Solution();
        System.out.println(solution.distanceK(root, root.left, 2));
    }
}

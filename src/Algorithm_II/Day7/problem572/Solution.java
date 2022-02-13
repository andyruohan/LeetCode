package Algorithm_II.Day7.problem572;

public class Solution {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSame(root, subRoot)) {
            return true;
        } else {
            if (root.left != null && root.right != null) {
                return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
            } else if (root.left != null) {
                return isSubtree(root.left, subRoot);
            } else if (root.right != null) {
                return isSubtree(root.right, subRoot);
            }
        }

        return false;
    }

    public static boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root != null && subRoot != null) {
            if (root.val == subRoot.val) {
                return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
            } else return false;
        } else return root == null && subRoot == null;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
//        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

//        TreeNode root = new TreeNode(1, new TreeNode(1), null);
//        TreeNode subRoot = new TreeNode(1);
        System.out.println(isSubtree(root, subRoot));
    }
}

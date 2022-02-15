package Algorithm_II.Day7.problem117;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node preNode = null;
            for (int i = 1; i <= n; i++) {
                Node curNode = queue.poll();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                if (i != 1) {
                    preNode.next = curNode;
                }
                preNode = curNode;
            }
        }
        return root;
    }
}

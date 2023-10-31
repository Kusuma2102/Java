import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class CheckCompletenessBinaryTree {
    public static boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                // A null node should not be followed by any non-null nodes.
                while (!queue.isEmpty() && queue.peek() == null) {
                    queue.poll();
                }

                // If there are any non-null nodes left, the tree is not complete.
                if (!queue.isEmpty()) {
                    return false;
                }
            } else {
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        if (isComplete(root)) {
            System.out.println("The binary tree is complete.");
        } else {
            System.out.println("The binary tree is not complete.");
        }
    }
}

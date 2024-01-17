package Trees;

import java.util.Stack;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class InOrderTraversalIterative {
    private TreeNode root;

    public InOrderTraversalIterative() {
        this.root = null;
    }

    public void inOrderTraversal() {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit the current node
            current = stack.pop();
            System.out.print(current.data + " ");

            // Move to the right subtree
            current = current.right;
        }
    }

    public static void main(String[] args) {
        InOrderTraversalIterative tree = new InOrderTraversalIterative();

        // Creating the binary tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.print("In-Order Traversal (Iterative): ");
        tree.inOrderTraversal();
    }
}

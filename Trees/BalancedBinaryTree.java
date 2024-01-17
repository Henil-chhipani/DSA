package Trees;

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

public class BalancedBinaryTree {
    private TreeNode root;

    public BalancedBinaryTree() {
        this.root = null;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true; // An empty tree is always balanced
        }

        // Check the height difference between left and right subtrees
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Check if both left and right subtrees are balanced
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();

        // Inserting elements into the binary tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        boolean isBalanced = tree.isBalanced();
        System.out.println("Is the binary tree balanced? " + isBalanced);
    }
}

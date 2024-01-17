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

public class BinaryTreeHeight {
    private TreeNode root;

    public BinaryTreeHeight() {
        this.root = null;
    }

    public int findHeight() {
        return findHeight(root);
    }

    private int findHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = findHeight(node.left);
            int rightHeight = findHeight(node.right);

            // Height of the tree is the maximum height of left or right subtree, plus 1 for
            // the current level
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        BinaryTreeHeight tree = new BinaryTreeHeight();

        // Inserting elements into the binary tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        int height = tree.findHeight();
        System.out.println("Height of the binary tree is: " + height);
    }
}

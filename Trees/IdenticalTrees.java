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

public class IdenticalTrees {
    private TreeNode root1;
    private TreeNode root2;

    public IdenticalTrees() {
        this.root1 = null;
        this.root2 = null;
    }

    public boolean areIdentical() {
        return areIdentical(root1, root2);
    }

    private boolean areIdentical(TreeNode node1, TreeNode node2) {
        // If both nodes are null, they are identical
        if (node1 == null && node2 == null) {
            return true;
        }

        // If one of the nodes is null (but not both), they are not identical
        if (node1 == null || node2 == null) {
            return false;
        }

        // Check if the current nodes have the same value and if their left and right
        // subtrees are identical
        return (node1.data == node2.data) &&
                areIdentical(node1.left, node2.left) &&
                areIdentical(node1.right, node2.right);
    }

    public static void main(String[] args) {
        IdenticalTrees trees = new IdenticalTrees();

        // Creating the first binary tree
        trees.root1 = new TreeNode(1);
        trees.root1.left = new TreeNode(2);
        trees.root1.right = new TreeNode(3);
        trees.root1.left.left = new TreeNode(4);
        trees.root1.left.right = new TreeNode(5);

        // Creating the second binary tree
        trees.root2 = new TreeNode(1);
        trees.root2.left = new TreeNode(2);
        trees.root2.right = new TreeNode(3);
        trees.root2.left.left = new TreeNode(4);
        trees.root2.left.right = new TreeNode(5);

        boolean identical = trees.areIdentical();
        System.out.println("Are the trees identical? " + identical);
    }
}

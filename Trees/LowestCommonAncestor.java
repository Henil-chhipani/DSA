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

public class LowestCommonAncestor {
    private TreeNode root;

    public LowestCommonAncestor() {
        this.root = null;
    }

    public TreeNode findLowestCommonAncestor(TreeNode p, TreeNode q) {
        return findLCA(root, p, q);
    }

    private TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) {
            return node;
        }

        TreeNode leftLCA = findLCA(node.left, p, q);
        TreeNode rightLCA = findLCA(node.right, p, q);

        if (leftLCA != null && rightLCA != null) {
            return node; // Both nodes are found in different subtrees, so the current node is the LCA
        }

        return (leftLCA != null) ? leftLCA : rightLCA; // Return the non-null LCA from left or right subtree
    }

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();

        // Creating the binary tree
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(1);
        tree.root.left.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(0);
        tree.root.right.right = new TreeNode(8);
        tree.root.left.right.left = new TreeNode(7);
        tree.root.left.right.right = new TreeNode(4);

        TreeNode p = tree.root.left; // Node with value 5
        TreeNode q = tree.root.left.right.right; // Node with value 4

        TreeNode lca = tree.findLowestCommonAncestor(p, q);
        System.out.println("Lowest Common Ancestor of " + p.data + " and " + q.data + " is: " + lca.data);
    }
}

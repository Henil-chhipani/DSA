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

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void printPreorder() {
        System.out.print("Preorder Traversal: ");
        printPreorder(root);
        System.out.println();
    }

    private void printPreorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public void printInorder() {
        System.out.print("Inorder Traversal: ");
        printInorder(root);
        System.out.println();
    }

    private void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    public void printPostorder() {
        System.out.print("Postorder Traversal: ");
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(TreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting elements into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Performing tree traversals
        tree.printPreorder(); // Should print: 50 30 20 40 70 60 80
        tree.printInorder(); // Should print: 20 30 40 50 60 70 80 lmr
        tree.printPostorder(); // Should print: 20 40 30 60 80 70 50 lrm // preorder:mlr
    }
}

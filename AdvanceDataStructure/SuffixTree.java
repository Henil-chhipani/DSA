package AdvanceDataStructure;

class SuffixTreeNode {
    SuffixTreeNode[] children;
    int start;
    Integer end;

    public SuffixTreeNode(int start, Integer end) {
        this.children = new SuffixTreeNode[256]; // Assuming ASCII characters
        this.start = start;
        this.end = end;
    }
}

public class SuffixTree {

    private SuffixTreeNode root;
    private String text;

    public SuffixTree(String text) {
        this.text = text;
        this.root = buildSuffixTree(text);
    }

    private SuffixTreeNode buildSuffixTree(String text) {
        SuffixTreeNode root = new SuffixTreeNode(-1, null);

        for (int i = 0; i < text.length(); i++) {
            insertSuffix(root, text.substring(i), i);
        }

        return root;
    }

    private void insertSuffix(SuffixTreeNode node, String suffix, int index) {
        if (suffix.isEmpty()) {
            node.end = index;
            return;
        }

        char ch = suffix.charAt(0);
        if (node.children[ch] == null) {
            node.children[ch] = new SuffixTreeNode(index, null);
        }

        SuffixTreeNode child = node.children[ch];
        int i = 1;

        while (i < suffix.length()) {
            if (child.start + i >= text.length() || text.charAt(child.start + i) != suffix.charAt(i)) {
                SuffixTreeNode newInternalNode = new SuffixTreeNode(child.start + i, child.end);
                child.end = child.start + i - 1;
                child.start = child.start + i;
                newInternalNode.children[suffix.charAt(i)] = child;
                node.children[ch] = newInternalNode;
                ch = suffix.charAt(i);
                child = newInternalNode;
            }

            if (child.start + i < text.length() && text.charAt(child.start + i) == suffix.charAt(i)) {
                break;
            }

            i++;
        }

        if (i == suffix.length()) {
            child.end = index;
        } else {
            insertSuffix(child, suffix.substring(i), index);
        }
    }

    public void printSuffixTree() {
        printSuffixTree(root, 0);
    }

    private void printSuffixTree(SuffixTreeNode node, int level) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        if (node.start == -1) {
            System.out.println("ROOT");
        } else {
            System.out.println(text.substring(node.start, node.end + 1));
        }

        for (SuffixTreeNode child : node.children) {
            printSuffixTree(child, level + 1);
        }
    }

    public static void main(String[] args) {
        String text = "banana";
        SuffixTree suffixTree = new SuffixTree(text);

        // The 'root' field of suffixTree is the root of the suffix tree
        System.out.println("Suffix Tree constructed for the string '" + text + "'");
        suffixTree.printSuffixTree();
    }
}

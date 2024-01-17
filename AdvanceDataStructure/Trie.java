package AdvanceDataStructure;

class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26]; // Assuming only lowercase English letters
        this.isEndOfWord = false;
    }

    public TrieNode getChild(char ch) {
        return children[ch - 'a'];
    }

    public void setChild(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord() {
        isEndOfWord = true;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);

            if (child == null) {
                child = new TrieNode();
                current.setChild(ch, child);
            }

            current = child;
        }

        current.setEndOfWord();
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);

            if (child == null) {
                return null; // Prefix not found
            }

            current = child;
        }

        return current;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");

        System.out.println("Search 'app': " + trie.search("app")); // true
        System.out.println("Search 'appl': " + trie.search("appl")); // false
        System.out.println("StartsWith 'app': " + trie.startsWith("app")); // true
    }
}

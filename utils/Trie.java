class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String word = ""; // must, otherwise root will null pointer
}

// java-smell (oop)
class Trie {
    private TrieNode root;

    // constructor
    public Trie() {
        this.root = new TrieNode();
    }

    // search word in trie
    public boolean search(String word) {
        TrieNode node = root;

        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) 
                return false;

            node = node.children[c - 'a'];
        }

        return node.word.equals(word);
    }

    // start with
    public boolean startwith(String word) {
        // System.out.println("str: " + word);
        TrieNode node = root;

        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) 
                return false;

            node = node.children[c - 'a'];
        }

        return true;
    }

    // insert a word to trie
    public void insert(String word) {
        TrieNode node = root;

        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) 
                node.children[c - 'a'] = new TrieNode();

            node = node.children[c - 'a'];
        }

        node.word = word;
    }
}

// c-smell (function)
public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    
    for (String w: words) {
        TrieNode node = root;
        
        for (char c: w.toCharArray()) {
            if (node.next[c - 'a'] == null) 
                node.next[c - 'a'] = new TrieNode();
            
            node = node.children[i];
       }

       node.word = w;
    }

    return root;
}
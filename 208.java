class Trie {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = "";
    }

    TrieNode root = new TrieNode();
    
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null)
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            
            node = node.children[word.charAt(i) - 'a'];
        }
        
        node.word = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null)
                return false;
            
            node = node.children[word.charAt(i) - 'a'];
        }
        
        return node.word.equals(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children[prefix.charAt(i) - 'a'] == null)
                return false;
            
            node = node.children[prefix.charAt(i) - 'a'];
        }
        
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
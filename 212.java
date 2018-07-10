class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // parameter
        Set<String> ans = new HashSet<>();
        Trie trie = new Trie();
        int m = board.length, n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        
        // build trie
        for (String w: words) {
            trie.insert(w);
        }
        
        // search
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(board, visit, trie, "", i, j, ans);   
            }
        }
        
        return new ArrayList<String>(ans);
    }
    
    public void backtrack(char[][] b, boolean[][] v, Trie t, String s, int i, int j, Set<String> ans) {
        // boundary and usage check 
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length) {
            return;  
        } 

        // used or no following words
        if (v[i][j] || !t.startwith(s)) {
            return;
        }
        
        // middle-way stop
        if (t.search(s) && s.length() != 0) {
            ans.add(s);
        }
        
        // backtrack
        v[i][j] = true;
        backtrack(b, v, t, s + b[i][j], i + 1, j, ans);
        backtrack(b, v, t, s + b[i][j], i - 1, j, ans);
        backtrack(b, v, t, s + b[i][j], i, j + 1, ans);
        backtrack(b, v, t, s + b[i][j], i, j - 1, ans);
        v[i][j] = false;
    }
}
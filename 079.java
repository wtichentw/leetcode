class Solution {
    public boolean exist(char[][] board, String word) {
        Set<Integer> visit = new HashSet<>();
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(visit, board, word, 0, i, j)) return true;
            }
        }
        
        return false;
    }
    
    public boolean search(Set<Integer> visit, char[][] board, String w, int idx, int i, int j) {
        // boundart check        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        
        // not match and used
        if (w.charAt(idx) != board[i][j] || visit.contains(i * board[0].length + j)) {
            return false;
        }

        // all match
        if (w.length() - 1 == idx) {
            return true;
        }
        
        visit.add(i * board[0].length + j);
        boolean s1 = search(visit, board, w, idx + 1, i + 1, j);
        boolean s2 = search(visit, board, w, idx + 1, i - 1, j);
        boolean s3 = search(visit, board, w, idx + 1, i, j + 1);
        boolean s4 = search(visit, board, w, idx + 1, i, j - 1);
        
        if (s1 || s2 || s3 || s4) {
            return true;
        }
        else {
            visit.remove(i * board[0].length + j);
            return false;
        }
    }
}
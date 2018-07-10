class Solution {
    public int countBattleships(char[][] board) {
        // parameter handle
        
        int m = board.length, n = board[0].length;
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    // check left
                    if (j > 0 && board[i][j - 1] == 'X') continue;
                    
                    // chech top
                    if (i > 0 && board[i - 1][j] == 'X') continue;
                    
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
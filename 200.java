class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    clear(grid, i, j);
                    ans ++;
                }
            }
        }
        
        return ans;
    }
    
    public void clear(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        clear(grid, i + 1, j);
        clear(grid, i - 1, j);
        clear(grid, i, j + 1);
        clear(grid, i, j - 1);
    }
}
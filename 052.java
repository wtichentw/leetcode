class Solution {
    Set<Integer> col = new HashSet<Integer>();
    Set<Integer> diag1 = new HashSet<Integer>();
    Set<Integer> diag2 = new HashSet<Integer>();
    
    public int totalNQueens(int n) {
        return backtrack(0, n);
    }
    
    public int backtrack(int row, int n) {
        // success
        if (row == n) {
            return 1;
        } 
        
        // try put Q at any pos of this column
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;
            
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);
            
            ans += backtrack(row + 1, n);
            
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
        
        return ans;
    }
}
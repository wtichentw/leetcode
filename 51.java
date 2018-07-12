class Solution {
    Set<Integer> col = new HashSet<Integer>();
    Set<Integer> diag1 = new HashSet<Integer>();
    Set<Integer> diag2 = new HashSet<Integer>();
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        
        backtrack(ans, cur, 0, n);
        
        return ans;
    }
    
    public void backtrack(List<List<String>> ans, List<String> cur, int row, int n) {
        // success
        if (row == n) {
            ans.add(new ArrayList<String>(cur));
            return;
        } 
        
        // try put Q at any pos of this column
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;
            
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[i] = 'Q';
            String next = new String(arr);
            
            cur.add(next);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);
            
            backtrack(ans, cur, row + 1, n);
            
            cur.remove(cur.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }
}
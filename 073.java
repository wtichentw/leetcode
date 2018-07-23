class Solution { // O(m + n) version
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        
        int m = matrix.length, n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }       
            }
        }
        
        for (int r: row) 
            for (int i = 0; i < n; i++)
                matrix[r][i] = 0;
        
        for (int c: col) 
            for (int i = 0; i < m; i++)
                matrix[i][c] = 0;
        
    }
}
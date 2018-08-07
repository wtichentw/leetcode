class Solution {
    class Cell {
        int row;
        int col;
        int val;
        
        Cell(int r, int c, int v) {
            this.row = r;
            this.col = c;
            this.val = v;
        }
    }
    
    public int[][] multiply(int[][] A, int[][] B) {
        int ma = A.length, na = A[0].length;
        int mb = B.length, nb = B[0].length;
        int[][] ans = new int[ma][nb];
        List<Cell> a = new ArrayList<>();
        List<Cell> b = new ArrayList<>();
        
        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < na; j++) {
                if (A[i][j] != 0) a.add(new Cell(i, j, A[i][j]));
            }
        }
        
        for (int i = 0; i < mb; i++) {
            for (int j = 0; j < nb; j++) {
                if (B[i][j] != 0) b.add(new Cell(i, j, B[i][j]));
            }
        }
        
        for (Cell ca: a) {
            for (Cell cb: b) {
                if (ca.col == cb.row)
                    ans[ca.row][cb.col] += ca.val * cb.val;
            }
        }
        
        return ans;
    }
}
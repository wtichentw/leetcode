class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = 0, idx = 0;
        int[] ret = new int[n * m];
        boolean up = true;
        
        while (i != n && j != m) {
            ret[idx++] = matrix[i][j];
            
            if (up) {
                i--;
                j++;
            }
            else {
                i++;
                j--;
            }
            
            if (j >= m) {
                i += 2;
                j -= 1;
                up = false;
            }
            else if (i >= n) {
                i -= 1;
                j += 2;
                up = true;
            }
            else if (i < 0) {
                i += 1;
                up = false;
            }
            else if (j < 0) {
                j += 1;
                up = true;
            }
        }
        
        return ret;
    }
}
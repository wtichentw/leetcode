class Solution {
    public int calculateMinimumHP(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.min(0, A[i][j]);
                }
                else if (i == m - 1) {
                    dp[i][j] = Math.min(0, A[i][j] + dp[i][j + 1]);
                }
                else if (j == n - 1) {
                    dp[i][j] = Math.min(0, A[i][j] + dp[i + 1][j]);
                }
                else {
                    int tmp = Math.max(A[i][j] + dp[i][j + 1], A[i][j] + dp[i + 1][j]);
                    dp[i][j] = Math.min(0, tmp);
                }
            }
        }
        
        return dp[0][0] * -1 + 1;
    }
}
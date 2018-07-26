class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] means with i's 0 and j's 1, maximal string nums 
        int[][] dp = new int[m + 1][n + 1];
        
        // from using 1 str to n str
        for (String str: strs) {
            int[] cnt = count(str);
            
            // rolling array start with most abundant resourse
            for (int i = m; i >= cnt[0]; i--) {
                for (int j = n; j >= cnt[1]; j--) {
                    if (i >= cnt[0] && j >= cnt[1]) 
                        dp[i][j] = Math.max(dp[i][j], dp[i - cnt[0]][j - cnt[1]] + 1);
                    // else 
                    //     dp[i][j] = dp[i][j]
                }
            }
        }
        
        return dp[m][n];
    }
    
    public int[] count(String s) {
        int one = 0; int zero = 0;
        
        for (char c: s.toCharArray()) {
            if (c == '0') zero++;
            else one++;
        }
        
        return new int[] {zero, one};
    }
}
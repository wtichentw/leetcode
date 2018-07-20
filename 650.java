class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1]; // min steps to reach length i
        
        for (int i = 2; i <= n; i++) {
            dp[i] = i; // we can always paste all the way down
            
            for (int j = i - 1; j > 1; j--) {
                // i / j == 2 -> copy 1 time paste 1 time
                // i / j == 3 -> copy 1 time paste 2 time
                if (i % j == 0) 
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
            }
        }
        
        return dp[n];
    }
}
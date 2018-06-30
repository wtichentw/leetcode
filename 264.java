class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        
        dp[1] = 1; // i-th ugly number
        
        int i = 2; 
        int idx2 = 1, idx3 = 1, idx5 = 1; 
        int val2 = 2, val3 = 3, val5 = 5; 
        while (i <= n) {
            int min = Math.min(Math.min(val2, val3), val5);
            
            dp[i++] = min;
            
            if (min == val2) val2 = dp[++idx2] * 2;
            if (min == val3) val3 = dp[++idx3] * 3;
            if (min == val5) val5 = dp[++idx5] * 5;
        }
        
        return dp[n];
    }
}
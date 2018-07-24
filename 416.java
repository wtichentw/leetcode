class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for (int n: nums) sum += n;
        
        if (sum % 2 != 0) return false;
        
        boolean[][] dp = new boolean[sum / 2 + 1][nums.length + 1];
        
        for (int i = 0; i <= sum / 2; i++) {
            for (int j = 0; j <= nums.length; j++) {
                if (i == 0) {
                    dp[i][j] = true;
                }
                else if (j == 0) {
                    dp[i][j] = false;
                }
                else {
                    // enough weight
                    if (i >= nums[j - 1]) 
                        dp[i][j] = dp[i][j - 1] || dp[i - nums[j - 1]][j - 1];
                    
                    // not enough, just see whether without j'th item is okay or not
                    else 
                        dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[sum / 2][nums.length];
    }
}
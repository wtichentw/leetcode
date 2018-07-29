class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for (int n: nums) sum += n;
        
        if (sum % 2 != 0) return false;
        
        // dp[i][j] means with i nums can we reach sum j
        boolean[] dp = new boolean[sum / 2 + 1];
        
        // skip first row by init
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum / 2; j >= nums[i - 1]; j--) {
                if (j >= nums[i - 1]) dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
            
        return dp[sum / 2];
    }
}
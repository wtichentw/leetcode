class Solution {
    public int maxSubArray(int[] A) {
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                dp[0] = nums[0];
            else 
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}
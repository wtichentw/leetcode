class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int cur = 0, ans = Integer.MAX_VALUE;
        
        while (i < n || j < n) {
            if (j < n && cur < s) {
                cur += nums[j];
                j++;
            }
            else if (i < n) {
                cur -= nums[i];
                i++;
            }
                
            if (cur >= s)
                ans = Math.min(ans, j - i);
        }
        
        return ans == Integer.MAX_VALUE? 0: ans;
    }
}
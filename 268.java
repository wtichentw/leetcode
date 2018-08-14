class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0, idx = 0;
        
        while (idx <= nums.length) {
            
            if (idx < nums.length)
                ans = ans ^ nums[idx] ^ idx;
            else 
                ans = ans ^ idx;
            
            idx += 1;
        }
        
        return ans;
    }
}
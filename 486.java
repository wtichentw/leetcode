class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        return helper(nums, 0, nums.length - 1) >= 0;
    }
    
    public int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];
            
        int takeLeft  = nums[left]  - helper(nums, left + 1, right);
        int takeRight = nums[right] - helper(nums, left, right - 1);
            
        return Math.max(takeLeft, takeRight);
    }
}
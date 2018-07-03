class Solution {
    public int rob(int[] nums) {
        int does = 0, dont = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int prevDoes = does, prevDont = dont; 
            
            does = prevDont + nums[i];
            dont = Math.max(prevDoes, prevDont);
        }
        
        return Math.max(does, dont);
    }
}
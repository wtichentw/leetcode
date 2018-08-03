class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // init
        int n = nums.length, ans = nums[0] + nums[1] + nums[nums.length - 1];
        
        Arrays.sort(nums);
        
        // n - 2 n - 1 
        for (int i = 0; i <= n - 3; i++) {
            int j = i + 1;
            int k = n - 1;
            
            while (j < k) {
                int cur = nums[i] + nums[j] + nums[k];
                
                if (Math.abs(cur - target) < Math.abs(ans - target)) 
                    ans = cur;
                
                if (cur > target) 
                    k--;
                else 
                    j++;
            }
        }
        
        return ans;
    }
}
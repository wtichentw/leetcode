class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
                
            if (map.get(sum) != null && i - map.get(sum) > 1) 
                return true;
            
            map.putIfAbsent(sum, i);
        }
        
        return false;
    }
}


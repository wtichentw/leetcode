class Solution {
    public int subarraySum(int[] nums, int k) {
        // count of particular sum value
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // sum[0, i]
            sum += nums[i]; 
            
            // S[j, i] == S[0, i] - S[0, j]
            //   k     ==   sum   -   a, since target is k
            //   a     ==   sum . -   k
            // so find count of a we can know how many k we can make bu current sum
            if (map.get(sum - k) != null) 
                ans += map.get(sum - k) ;
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return ans;
    }
}
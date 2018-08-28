class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) return new ArrayList<List<Integer>>();
        
        List<List<Integer>> ans = new LinkedList<>();
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            
            int j = i + 1, k = n - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    ans.add(tmp);
                    
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }   
                else if (sum < 0) {
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    j++;
                }
                else {
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    k--;
                }
            }
        }
        
        return ans;
    }
}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for (int i = 0; i <= n - 4; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j <= n - 3; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                
                int a = j + 1, b = n - 1;
                
                while (a < b) {
                    int sum = nums[i] + nums[j] + nums[a] + nums[b];
                    
                    if (sum == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[a]);
                        tmp.add(nums[b]);
                        ans.add(tmp);
                        
                        while (a < b && nums[a] == nums[a + 1]) a++;
                        while (a < b && nums[b] == nums[b - 1]) b--;
                        a++;
                        b--;
                    }
                    else if (sum < target) {
                        while (a < b && nums[a] == nums[a + 1]) a++;
                        a++;
                    }
                    else {
                        while (a < b && nums[b] == nums[b - 1]) b--;
                        b--;
                    }
                }
                
            }
        }

        return ans;
    }
}
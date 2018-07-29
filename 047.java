class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        helper(ans, cur, nums, visit);
        
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, List<Integer> cur, int[] nums, boolean[] visit) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;
            
            // not first one && value equals previous one  && previous one not used -> each row has no duplicate num
            if (i > 0 && nums[i-1] == nums[i] && !visit[i-1]) continue;            
            
            visit[i] = true;
            cur.add(nums[i]);

            helper(ans, cur, nums, visit);

            visit[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
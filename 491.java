class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> cur = new ArrayList<>();
        
        dfs(ans, cur, nums, 0);
        
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, List<Integer> cur, int[] nums, int idx) {
        // terminal
        if (cur.size() >= 2) 
            ans.add(new ArrayList<>(cur));
            
        if (idx >= nums.length) 
            return;        
        
        // local set
        Set<Integer> used = new HashSet<>();
        
        // try every possibility
        for (int i = idx; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;
            
            // check if it's okay to add
            if (cur.size() == 0 || nums[i] >= cur.get(cur.size() - 1)) {
                used.add(nums[i]);
                
                cur.add(nums[i]);
                dfs(ans, cur, nums, i + 1);
                cur.remove(cur.size() - 1);
            }
          
        }
    }
}
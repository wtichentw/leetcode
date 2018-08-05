class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        boolean[] exist = new boolean[nums.length];
        int n = nums.length;
        
        for (int i: nums) 
            exist[i-1] = true;
        
        for (int i = 0; i < n; i++)
            if (!exist[i])
                ans.add(i+1);
        
        return ans;
    }
}
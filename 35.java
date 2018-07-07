class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        while (l + 1 < r) { // l, r won't go in but l, l+1, r will
            int m = (l + r) / 2;
            
            if (nums[m] == target) {
                return m;
            }
            else if (nums[m] < target) {
                l = m;
            }
            else {
                r = m;
            }
        }
        
        if (target > nums[r]) return r + 1;
        else if (target > nums[l]) return r;
        else return l;
    }
}
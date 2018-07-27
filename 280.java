class Solution {
    public void wiggleSort(int[] nums) {
        // NOTE i + 1
        for (int i = 0; i + 1 < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) swap(nums, i, i + 1);
            } 
            else {
                if (nums[i] < nums[i + 1]) swap(nums, i, i + 1);
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
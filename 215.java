class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }
    
    public int quickSelect(int[] nums, int start, int end, int k) {
        int i = start, j = end;
        int pivot = nums[(i + j) / 2];
        
        while (i <= j) {
            
            // find smaller from left 
            while (i <= j && nums[i] > pivot) i++;
            
            // find bigger from right
            while (i <= j && nums[j] < pivot) j--;
            
            
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        
        if (start + (k - 1) <= j) {
            return quickSelect(nums, start, j, k);
        }
        
        if (start + (k - 1) >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }
        
        return nums[j + 1];
    }
}
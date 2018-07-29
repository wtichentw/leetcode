class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        
        // find i that nums[i] > nums[i - 1]
        // nums[i + 1]...nums[n - 1] will be descending
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1]) break;
            else i--;
        }
        
        // if not descending, need find second bigger to swap
        if (i != 0) {
            int j = nums.length - 1;
            
            while (j >= 0) {
                if (nums[j] > nums[i - 1]) break;
                else j--;
            }
            
            swap(nums, i - 1, j);
        }   
        
        // reverse arr from i...n-1
        reverse(nums, i, nums.length - 1);
    }
    
    public void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) swap(nums, lo++, hi--);
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}


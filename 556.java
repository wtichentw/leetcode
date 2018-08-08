class Solution {
    public int nextGreaterElement(int n) {
        char[] num = Integer.toString(n).toCharArray();
        
        int i, j;

        for (i = num.length - 1; i > 0; i--)
            if (num[i] > num[i - 1]) break;
        
        if (i == 0) return -1;
        
        for (j = i; j < num.length; j++)
            if (num[j] <= num[i - 1]) break;

        // one step back since we are looking num[j] > num[i - 1]
        j--;
        
        swap(num, i - 1, j);
        reverse(num, i, num.length - 1);
        
        long val = Long.parseLong(new String(num));
        return (val <= Integer.MAX_VALUE)? (int) val: -1;
    }
    
    public void reverse(char[] nums, int lo, int hi) {
        while (lo < hi) swap(nums, lo++, hi--);
    }
    
    public void swap(char[] nums, int a, int b) {
        char temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        
        int i = 0, j = height.length - 1;
        int ans = 0, cur = 0;
        while (i < j) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            
            if (height[i] > height[j])
                j--;
            else 
                i++;
        }
        
        return ans;
    }
}
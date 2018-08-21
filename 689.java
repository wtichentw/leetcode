class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] maxLeft = new int[n];  // max interval 
        int[] maxRight = new int[n];
        int[] sum = new int[n + 1];
        int[] ans = new int[3];
        
        // sum of element
        for (int i = 0; i < n; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        
        // max left start pos for subarray num[0, i]
        // so start compare from k since we need at least 2 intervals to compare
        for (int i = k, max = sum[k] - sum[0]; i < n; i++) {
            
            // sum of interval num[i - k, i] == sum[i + 1] - sum[i + 1 - k]
            if (sum[i + 1] - sum[i + 1 - k] > max) {
                max = sum[i + 1] - sum[i + 1 - k];
                maxLeft[i] = i + 1 - k;
            }
            
            // use previous
            else {
                maxLeft[i] = maxLeft[i - 1];
            }
        }
        
        // max left start pos for subarray num[i, n - 1] 
        maxRight[n - k] = n - k;
        for (int i = n - k - 1, max = sum[n] - sum[n - k]; i >= 0; i--) {
            
            if (sum[i + k] - sum[i] >= max) {
                max = sum[i + k] - sum[i];
                maxRight[i] = i;
            }
            else {
                maxRight[i] = maxRight[i + 1];
            }
        }
        
        int maxsum = Integer.MIN_VALUE;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = maxLeft[i - 1], r = maxRight[i + k];
            int tmp = sum[i + k] - sum[i] + sum[l + k] - sum[l] + sum[r + k] - sum[r];
            
            if (tmp > maxsum) {
                maxsum = tmp;
                ans[0] = l; ans [1] = i; ans[2] = r;
            }
            
        }
        
        return ans;
    }
}
class Solution {
    public int candy(int[] ratings) {
        int[] num = new int[ratings.length];
        int ans = 0;
        
        // [1,0,2]
        
        // [1,1,1]
        Arrays.fill(num, 1);
        
        // [1,1,2]
        for (int i = 1; i < num.length; i++) {
            if (ratings[i] > ratings[i - 1]) 
                num[i] = num[i - 1] + 1;
        }
        
        // [2,1,2]
        for (int i = num.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) 
                num[i] = Math.max(num[i + 1] + 1, num[i]);
        }
        
        for (int c: num) {
            ans += c;
        }
        
        return ans;
    }
}
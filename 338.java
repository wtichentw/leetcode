class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        
        for (int i = 0; i <= num; i++) {
            ans[i] = getNumOfOneBits(i);
        }

        return ans;
    }
    
    public int getNumOfOneBits(int n) {
        int ans = 0;
        
        while (n != 0) {
            if (n % 2 == 1) ans += 1;
            n /= 2;
        }
        
        return ans;
    }
}
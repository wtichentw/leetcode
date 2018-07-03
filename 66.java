class Solution {
    public int[] plusOne(int[] digits) {
        // no carry addition
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }    
            
            digits[i] = 0;
        } 
        
        // carry addition
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        // for (int i = 1; i < ans.length; i++) {
        //     ans[i] = 0;
        // }
        
        return ans;
    }
}
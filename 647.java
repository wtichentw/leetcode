class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            ans += extendPalindrome(s, i, i);
            ans += extendPalindrome(s, i, i + 1);
        }
        
        return ans;
    }
    
    public int extendPalindrome(String str, int left, int right) {
        int ans = 0;
        
        while (left >= 0 && right < str.length() &&
               str.charAt(left) == str.charAt(right)) {
            ans   += 1;
            left  -= 1;
            right += 1;
        }
        
        return ans;
    }
}
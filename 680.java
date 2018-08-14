class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isP(s, l + 1, r) || isP(s, l, r -1);
            }
            
            l++;
            r--;
        }
        
        return true;
    }
    
    public boolean isP(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }
        
        return true;
    }
}
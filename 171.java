class Solution {
    public int titleToNumber(String s) {
        int ans = 0, base = 1;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += base * (s.charAt(i) - 'A' + 1);
            base *= 26;
        }
        
        return ans;
    }
}
class Solution {
    public int romanToInt(String s) {
        // Symbol       Value
        // I             1
        // V             5
        // X             10
        // L             50
        // C             100
        // D             500
        // M             1000
        // I can be placed before V (5) and X (10) to make 4 and 9. 
        // X can be placed before L (50) and C (100) to make 40 and 90. 
        // C can be placed before D (500) and M (1000) to make 400 and 900.
        int ans = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (c == 'I') ans += ans >=   5?   -1:   1;
            if (c == 'V') ans += 5;
            if (c == 'X') ans += ans >=  50?  -10:  10; // since from back at least add 500 already
            if (c == 'L') ans += 50;
            if (c == 'C') ans += ans >= 400? -100: 100;
            if (c == 'D') ans += 500;
            if (c == 'M') ans += 1000;
        }

        return ans;
    }
}
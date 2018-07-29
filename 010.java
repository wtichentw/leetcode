class Solution {
    public boolean isMatch(String s, String p) {
        
        
        // dp[i][j] means s[0, i] matches p[0, j] or not
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        // foundation
        dp[0][0] = true;
        
        // preprocess make [aab] accessible from [c*aab]
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) dp[0][j + 1] = true;
        }
        
        // build dp table
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }        
                else if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                else if (p.charAt(j) == '*') {
                    
                    // erase x* (x != .)
                    if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                    
                    // single = dp[i + 1][j] since we dont use * and look back for 1 unit shorter p
                    // multiple = dp[i][j + 1] use 1 unit shorter s as if the last char doesn'y exist, so multiple
                    // empty = dp[i + 1][j - 1] since just getrid of x* p by shrinking 2 units
                    else {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }
            }
        }
        
            
        return dp[s.length()][p.length()];
    }
}
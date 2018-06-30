class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1]; // dp[i] means s.substring(0, i) can be word-breaked
        
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                
                if (dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            
            }
        }
        
        return dp[s.length()];
    }
}
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        
        int n = envelopes.length;
        int[] dp = new int[n];
        
        // Sort first according to width and then height
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override 
            public int compare(int[] a, int[] b) {
                return a[0] == b[0]? b[1] - a[1]: a[0] - b[0];
            }
        });
        
        // 0/1 knapsnack -> from using 1 envelope to using n envelope
        int ret = 0;
        for (int i = 0; i < n; i++) {
            
            // at least 1 envelop 
            dp[i] = 1;
            
            // try to wrap envelope j with envelope i 
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] &&
                    envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            ret = Math.max(dp[i], ret);
        }
        
        return ret;
    }
}